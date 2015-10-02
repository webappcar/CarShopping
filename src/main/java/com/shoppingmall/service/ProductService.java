package com.shoppingmall.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shoppingmall.dao.ProductDao;
import com.shoppingmall.model.Product;

public class ProductService {
	ProductDao dao;
	
	public void setProductDao(ProductDao dao) {
		// TODO Auto-generated constructor stub
		
		this.dao = dao;
	}
	
	@Transactional
	public List<Product> selectProduct(){
		
		return dao.selectProduct();
	}
	
	@Transactional
	public Product selectOneProduct(int car_id){
		
		return dao.selectOneProduct(car_id);
	}
	
	@Transactional
	public List<Product> selectProducts(String company, String gubun){
		
		return dao.selectProducts(company, gubun);
	}
	
	@Transactional
	public int insertProduct(Product product){
		
		return dao.insertProduct(product);
	}
	
	public int modifyProduct(Product product){
		
		return dao.modifyProduct(product);
	}
}
