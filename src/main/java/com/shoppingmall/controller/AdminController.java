package com.shoppingmall.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingmall.command.Fuel;
import com.shoppingmall.command.ProductCommand;
import com.shoppingmall.model.Member;
import com.shoppingmall.model.Product;
import com.shoppingmall.model.Purchase;
import com.shoppingmall.service.MemberListService;
import com.shoppingmall.service.ProductService;
import com.shoppingmall.service.PurchaseService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	ProductService service;

	PurchaseService purchaseService;
	
	@Autowired
	MemberListService mservice;
	
	public void paging(int total){
		/** 현재 페이지 */
		int nowPage = 1;
		
		/** 한 페이지당 출력할 게시글 수  */
		int pageSize = 5;
		
	    int limit = (nowPage - 1) * pageSize;
	    
	    int totalCount = total;
	    
	    /** 현재 페이지 nowPage = 1
		 *  한페이지당 출력할 게시글 수 pageSize = 5
		 *  totalCount = 전체 글 갯수*/
		
		/** 한 블럭에 보여질 페이지 수 */
		int recordCountPerPage = 10;

	    /** 현재 블럭 */
	    double nowBlock = (float)nowPage/recordCountPerPage;
	    nowBlock = Math.ceil(nowBlock);
	    
	    /** 현재 블럭에서 시작페이지 번호 */
	    int startPage = (int) (((nowBlock - 1) * recordCountPerPage) + 1);
	    
	    /** 현재 블럭에서 마지막 페이지 번호 */
	    int endPage = startPage + recordCountPerPage - 1;

	    /** 총 게시글 페이지 수 */
	    double totalPage = (float)totalCount / pageSize;
	    totalPage = Math.ceil(totalPage);

	    endPage = endPage >= totalPage ? endPage = (int) totalPage : endPage;
	    
	    nowBlock = nowBlock <= 1 ? 1 : nowBlock;
	}
	
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
	public String adminMemberPage(Model model){
		
		List<Member> list = mservice.getListAll();

		model.addAttribute("member", list);
		
		return "admin/adminMemberPage";
	}
	
	@RequestMapping("/productPage")
	public String adminProductPage(Model model){
		
		List<Product> list = service.selectProduct();

		model.addAttribute("product", list);
		
		return "admin/adminProductPage";
	}
	
	
	@RequestMapping("/orderPage")
	public String adminOrderPage(Model model){
//		
//		List<Purchase> purchaseList = purchaseService.purchaseSelect();
//		
//		model.addAttribute("purchaseList",purchaseList);
//		
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

	
	@RequestMapping(value="/insertProduct", method = RequestMethod.POST)
	public String insert(MultipartFile fileData, ProductCommand command){
		String path = "C:\\03_src\\Spring\\CarShopping\\src\\main\\webapp\\WEB-INF\\img\\carimg";
		path = "C:\\03_src\\SpringWorkSpace\\CarShopping\\src\\main\\webapp\\WEB-INF\\img\\carimg";
		File convFile = new File(path+"\\"+fileData.getOriginalFilename());
		
		String car_image = fileData.getOriginalFilename();
		
		command.setCar_image(car_image);
		
		try {
			fileData.transferTo(convFile);
			service.insertProduct(command.getProduct());	
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "redirect:/admin/productPage";
	}
	
	@RequestMapping("/deleteProduct")
	public String delete(int car_id, Product p){
		String path = "C:\\03_src\\Spring\\CarShopping\\src\\main\\webapp\\WEB-INF\\img\\carimg";
		path = "C:\\03_src\\SpringWorkSpace\\CarShopping\\src\\main\\webapp\\WEB-INF\\img\\carimg";
		
		p = service.selectOneProduct(car_id);
		
		File convFile = new File(path+"\\"+p.getCar_image());
		
		convFile.delete();
		
		service.deleteProduct(car_id);
		
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
