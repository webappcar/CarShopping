package com.shoppingmall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingmall.command.Fuel;
import com.shoppingmall.command.ProductCommand;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	MessageSource messageSource;
	
	@ModelAttribute("fuel")
	public List<Fuel> getFuel(){
		Locale locale = new Locale("ko");
		
		List<Fuel> fuels = new ArrayList<Fuel>();
		fuels.add(new Fuel("diesel",messageSource.getMessage("shoppingmall.productregist.fuel.diesel", null, locale)));
		fuels.add(new Fuel("gasoline", messageSource.getMessage("shoppingmall.productregist.fuel.gasoline", null, locale)));
		fuels.add(new Fuel("LPG",messageSource.getMessage("shoppingmall.productregist.fuel.lpg", null, locale)));
		fuels.add(new Fuel("hybrid",messageSource.getMessage("shoppingmall.productregist.fuel.hybrid", null, locale)));
		fuels.add(new Fuel("electric", messageSource.getMessage("shoppingmall.productregist.fuel.electric", null, locale)));
		return fuels;
	}
	
	@ModelAttribute("productinsert")
	public ProductCommand getProduct(){
		ProductCommand product = new ProductCommand();

		return product;
	}
	
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
