package com.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingMallController {
	
	@RequestMapping("/index")
	public String test(){
		
		return "index";
	}
	
	@RequestMapping("/memberJoin")
	public String memberJoin(){
		
		return "user/memberJoin";
	}
}
