package com.shoppingmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingmall.command.LoginCommand;
import com.shoppingmall.command.MemberCommand;
import com.shoppingmall.dao.MybatisMemberDao;
import com.shoppingmall.exception.AlreadyExistingMemberException;
import com.shoppingmall.exception.IdPassswordNotMatchException;
import com.shoppingmall.model.AuthInfo;
import com.shoppingmall.model.Member;
import com.shoppingmall.model.Product;

import com.shoppingmall.model.Review;
import com.shoppingmall.service.AuthService;
import com.shoppingmall.service.MemberListService;
import com.shoppingmall.service.MemberRegisterService;
import com.shoppingmall.validator.MemberCommandValidator;
import com.shoppingmall.dao.MybatisMemberDao;
import com.shoppingmall.dao.MybatisReviewDao;
import com.shoppingmall.service.ProductService;

import com.shoppingmall.model.Purchase;
import com.shoppingmall.service.PurchaseService;
import com.shoppingmall.model.Purchase;
import com.shoppingmall.model.ShoppingBag;
import com.shoppingmall.service.AuthService;
import com.shoppingmall.service.MemberListService;
import com.shoppingmall.service.MemberRegisterService;
import com.shoppingmall.service.ProductService;
import com.shoppingmall.service.PurchaseService;
import com.shoppingmall.service.ShoppingBagService;
import com.shoppingmall.validator.MemberCommandValidator;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	static Log log = LogFactory.getLog(MemberController.class);
	
	@Autowired
	MybatisMemberDao memberDao;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ProductService service;

	PurchaseService pService;
	ShoppingBagService sbService;
	
	@Autowired
	MemberListService listService;
	
	@Autowired
	MemberRegisterService registerService;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	MemberCommandValidator validator;
	
	@Autowired
	MybatisReviewDao reviewDao;
	
	@ModelAttribute("member")
	public MemberCommand getMemberCommand() {
		MemberCommand member = new MemberCommand();
		return member;
	}
	
	@RequestMapping(value={"/login"}, method=RequestMethod.GET)
	public String loginForm(@ModelAttribute("login") LoginCommand command) {
		log.info("loginForm()...");
		command.setRemember(true);
		
		return "member/loginForm";
	}
	
	@RequestMapping(value={"/login"}, method=RequestMethod.POST)
	public String login(@ModelAttribute("login") LoginCommand login, 
												 Errors errors,
												 HttpSession session, Model model) {
		
		/*
		 * login process
		 */		
		System.out.println("login.getId() = "+login.getId());
		System.out.println("login.getPassword() = "+login.getPassword());
		try {
			AuthInfo auth = authService.authenticate(login.getId(), login.getPassword());
			
			session.setAttribute("auth", auth);
			session.setAttribute("ID", auth.getId());
			session.setAttribute("NAME", auth.getName());
			session.setAttribute("NICKNAME", auth.getNickname());
			String session_id = (String) session.getAttribute("ID");
			System.out.println("session ID -------------------> "+session_id);
			
		} catch (IdPassswordNotMatchException ex) {			
			//errors.reject("idPasswordNotMatch");
			String idPasswordNotMatch = "true";
			model.addAttribute("idPasswordNotMatch", idPasswordNotMatch);
			log.info("idPasswordNotMatch=====================================================");
			
			return "member/loginForm";
		}
		
		return "redirect:/index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		log.info("logout process...");
		
		String session_id = (String) session.getAttribute("ID");
		System.out.println("session ID -------------------> "+session_id);
		String session_name = (String) session.getAttribute("NAME");
		System.out.println("session NAME -------------------> "+session_name);
		
		session.invalidate();  //세션삭제
		
		return "redirect:/index";
	}
	
	@RequestMapping("/list")
	public String getList(Model model) {
		List<Member> memberlist = listService.getListAll();
		
		model.addAttribute("memberlist", memberlist);
		
		return "member/member_list";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.GET)
	public String memberJoin(){
		
		return "member/member_join";
	}
	
	@RequestMapping(value="/memberJoin", method=RequestMethod.POST)
	public String regist(@ModelAttribute("member") MemberCommand command, Errors errors) {
		/*
		 * Validation
		 */
		log.info("command = " + command);

		//validator.validate(command, errors);
		
		if (errors.hasErrors()) {
			command.setPassword("");
			return "member/registForm";
		}
		
		/*
		 * DB 등록
		 */
		try {
			registerService.register(command.getMember());
		} catch (AlreadyExistingMemberException e) {
			log.error("Member Existing...", e);
			errors.reject("duplicate");
			return "member/registForm";
		}
		
		return "member/registSuccess";
	}
	
	@RequestMapping("/view/{member_id}")
	public String memberView(@PathVariable String member_id, Model model) {
		Member member = memberDao.selectById(member_id);
		
		model.addAttribute("member", member);
		
		return "member/member_view";
	}
	
	@RequestMapping("/productView")
	public String productView(int car_id, Model model, HttpSession session){
		
		Product product = service.selectOneProduct(car_id);
		
		model.addAttribute("oneProduct", product);

		//리뷰목록 가져오기
		List<Review> reviewList = reviewDao.selectReviewList(car_id);
		model.addAttribute("reviewList", reviewList);
		
		String session_id = (String)session.getAttribute("ID");
		
		if(session_id != null){
			Member member = listService.getSelectById(session_id);
			model.addAttribute("name", member.getNickname());
		}
		
		return "member/memberProductView";
	}

	
	@RequestMapping("/memberShoppingBasket")
	public String memberShoppingBasket(HttpSession session, Model model){
		String session_id = (String) session.getAttribute("ID");
		List<ShoppingBag> sb = sbService.selectShoppingBag(session_id);
		
		model.addAttribute("sb", sb);
		
		return "member/memberShoppingBasket";
	}
	
	@RequestMapping(value="/insertPurchase", method=RequestMethod.POST)
	public String insertPurchase(HttpSession session,int car_id, Purchase purchase){
		Product product = service.selectOneProduct(car_id);
		String session_id = (String) session.getAttribute("ID");
		
		String purchaseNo = car_id+session_id+(int)(Math.random()*1000+1);
		
		purchase.setPurchase_no(purchaseNo);
		purchase.setCode(String.valueOf(product.getCar_id()));
		purchase.setId(session_id);

		System.out.println(purchase.getPurchase_no());
		System.out.println(purchase.getCode());
		System.out.println(purchase.getId());
		System.out.println(purchase.getName());
		System.out.println(purchase.getAddress());
		System.out.println(purchase.getTelnum());
		
		pService.purchaseInsert(purchase);
		
		return "redirect:/index";
	}
}
