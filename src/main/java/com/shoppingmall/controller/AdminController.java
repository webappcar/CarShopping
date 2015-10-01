package com.shoppingmall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingmall.command.Fuel;
import com.shoppingmall.command.ProductCommand;
import com.shoppingmall.model.Product;
import com.shoppingmall.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ProductService service;
	
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
	
	/*
	 * Admin MainPage
	 */
	
	@RequestMapping("/memberPage")
	public String adminMemberPage(){
		
		return "admin/adminMemberPage";
	}
	
	@RequestMapping("/productPage")
	public String adminProductPage(Model model){
		
		List<Product> list = service.selectProduct();

		model.addAttribute("product", list);
		
		return "admin/adminProductPage";
	}
	
	
	@RequestMapping("/orderPage")
	public String adminOrderPage(){
		
		return "admin/adminOrderPage";
	}
	
	@RequestMapping("/boardPage")
	public String adminBoardPage(){
		
		return "admin/adminBoardPage";
	}
	
	
	/*
	 * Admin Product
	 */
	
	@RequestMapping("/productInsert")
	public String productInsert(){

		return "admin/product/productInsert";
	}
	
	@RequestMapping("/insertProduct")
	public String insert(ProductCommand command){
		
		service.insertProduct(command.getProduct());
		
		return "redirect:/admin/productPage";
	}
	
	@RequestMapping("/productModify")
	public String productModify(int car_id, Model model){

		Product product = service.selectOneProduct(car_id);

		model.addAttribute("product", product);
		
		return "admin/product/productModify";
	}
	
	@RequestMapping("/modifyProduct")
	public String modifyProduct(ProductCommand command){
		
		service.modifyProduct(command.getProduct());
		
		return "redirect:/admin/productPage";
	}
	
	/*
	 * Admin Order
	 */
	
	@RequestMapping("/orderModify")
	public String orderModify(){
		
		return "admin/order/orderModify";
	}
	
	@RequestMapping("/orderRefund")
	public String orderRefund(){
		
		return "admin/order/orderRefund";
	}
}
