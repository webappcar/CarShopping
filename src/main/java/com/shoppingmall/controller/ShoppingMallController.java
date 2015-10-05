package com.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingmall.model.Product;
import com.shoppingmall.service.ProductService;

@Controller
public class ShoppingMallController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping("/index")
	public String mainPage(Model model){
		
		List<Product> product = service.selectProduct();
		
		model.addAttribute("product", product);
		
		return "index";
	}
	
	@RequestMapping("/memberJoin")
	public String memberJoin(){
		
		return "user/memberJoin";
	}
}
