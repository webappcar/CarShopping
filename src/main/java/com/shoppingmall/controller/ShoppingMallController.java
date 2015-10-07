package com.shoppingmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingmall.model.Member;
import com.shoppingmall.model.Product;
import com.shoppingmall.service.MemberListService;
import com.shoppingmall.service.ProductService;

@Controller
public class ShoppingMallController {
	
	@Autowired
	ProductService service;
	
	@Autowired
	MemberListService mservice;
	
	@RequestMapping("/index")
	public String mainPage(Model model, HttpSession session){
		
		List<Product> hotItemProduct = service.selectHotItemProduct();
		List<Product> newItemProduct = service.selectNewItemProduct();
		String session_id = (String)session.getAttribute("ID");
		
		if(session_id != null){
			Member member = mservice.getSelectById(session_id);
			model.addAttribute("name", member.getNickname());
		}
		
		model.addAttribute("hotItemProduct", hotItemProduct);
		model.addAttribute("newItemProduct", newItemProduct);
		
		return "index";
	}
	
	
}
