package com.shoppingmall.controller;

import java.util.List;

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

@Controller
@RequestMapping("/member")
public class MemberController {
	
	static Log log = LogFactory.getLog(MemberController.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	MemberListService listService;
	
	@Autowired
	MemberRegisterService service;
	
	//@Autowired
	//MemberCommandValidator validator;
	
	@ModelAttribute("member")
	public MemberCommand getMemberCommand() {
		MemberCommand member = new MemberCommand();
		return member;
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
			service.register(command.getMember());
		} catch (AlreadyExistingMemberException e) {
			log.error("Member Existing...", e);
			errors.reject("duplicate");
			return "member/registForm";
		}
		
		return "member/registSuccess";
	}

}