package com.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/memberPage")
	public String adminMemberPage(){
		
		return "admin/adminMemberPage";
	}
	
	@RequestMapping("/productPage")
	public String adminProductPage(){
		
		return "admin/adminProductPage";
	}
	
	@RequestMapping("/productInsert")
	public String productInsert(){
		
		return "product/productInsert";
	}
	
	@RequestMapping("/orderPage")
	public String adminOrderPage(){
		
		return "admin/adminOrderPage";
	}
	
	@RequestMapping("/boardPage")
	public String adminBoardPage(){
		
		return "admin/adminBoardPage";
	}
}
