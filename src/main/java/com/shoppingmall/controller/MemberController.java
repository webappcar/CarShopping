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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shoppingmall.command.LoginCommand;
import com.shoppingmall.exception.AlreadyExistingMemberException;
import com.shoppingmall.exception.IdPassswordNotMatchException;
import com.shoppingmall.model.AuthInfo;
import com.shoppingmall.model.Member;
import com.shoppingmall.model.Product;
import com.shoppingmall.service.AuthService;
import com.shoppingmall.service.MemberListService;
import com.shoppingmall.service.MemberRegisterService;
import com.shoppingmall.service.ProductService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	static Log log = LogFactory.getLog(MemberController.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ProductService service;
	
	@Autowired
	MemberListService listService;
	
	@Autowired
	MemberRegisterService registerService;
	
	@Autowired
	AuthService authService;
	
	//@Autowired
	//MemberCommandValidator validator;
	
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
												 HttpSession session) {
		
		log.info("login()... " + login);
		/*
		 * validation
		 */
		
		if (errors.hasErrors()) {
			errors.reject("idPasswordNotMatch");
			return "member/loginForm";
		}
		
		/*
		 * login process
		 */
		try {
			AuthInfo auth = authService.authenticate(login.getId(), login.getPassword());
			
			session.setAttribute("auth", auth);
			
		} catch (IdPassswordNotMatchException ex) {
			
			//errors.reject("idPasswordNotMatch");
			log.info("idPasswordNotMatch~~~~~~~~~~~~~~~~~~~");
			
			return "member/loginForm";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/list")
	public String getList(Model model) {
		List<Member> memberlist = listService.getListAll();
		
		model.addAttribute("memberlist", memberlist);
		
		return "member/member_list";
	}
	
	@RequestMapping("/productView")
	public String productView(int car_id, Model model){
		
		Product product = service.selectOneProduct(car_id);
		
		model.addAttribute("oneProduct", product);
		
		return "user/memberProductView";
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

}
