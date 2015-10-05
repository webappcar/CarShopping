package com.shoppingmall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.shoppingmall.exception.AlreadyExistingMemberException;
import com.shoppingmall.model.Member;
import com.shoppingmall.service.MemberListService;
import com.shoppingmall.service.MemberRegisterService;
import com.shoppingmall.validator.MemberCommandValidator;
import com.shoppingmall.service.AuthService;
import com.shoppingmall.exception.IdPassswordNotMatchException;
import com.shoppingmall.model.AuthInfo;
import com.shoppingmall.command.LoginCommand;
import com.shoppingmall.command.MemberCommand;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	static Log log = LogFactory.getLog(MemberController.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	MemberListService listService;
	
	@Autowired
	MemberRegisterService registerService;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	MemberCommandValidator validator;
	
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
		
		/*if (errors.hasErrors()) {
			errors.reject("idPasswordNotMatch");
			return "member/loginForm1";
		}*/
		
		/*
		 * login process
		 */
		
		System.out.println("login.getId() = "+login.getId());
		System.out.println("login.getPassword() = "+login.getPassword());
		try {
			AuthInfo auth = authService.authenticate(login.getId(), login.getPassword());
			
			//session.setAttribute("auth", auth);
			session.setAttribute("ID", auth.getId());
			session.setAttribute("NAME", auth.getName());
			String session_id = (String) session.getAttribute("ID");
			System.out.println("session ID -------------------> "+session_id);
			
		} catch (IdPassswordNotMatchException ex) {
			
			errors.reject("idPasswordNotMatch");
			log.info("idPasswordNotMatch=====================================================");
			
			return "member/loginForm";
		}
		
		return "/index";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		log.info("logout process...");
		
		String session_id = (String) session.getAttribute("ID");
		System.out.println("session ID -------------------> "+session_id);
		String session_name = (String) session.getAttribute("NAME");
		System.out.println("session NAME -------------------> "+session_name);
		
		session.invalidate();  //세션삭제
		
		return "/index";
	}
	
	@RequestMapping("/list")
	public String getList(Model model) {
		List<Member> memberlist = listService.getListAll();
		
		model.addAttribute("memberlist", memberlist);
		
		return "member/member_list";
	}
	
	@RequestMapping("/productView")
	public String productView(){
		
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
