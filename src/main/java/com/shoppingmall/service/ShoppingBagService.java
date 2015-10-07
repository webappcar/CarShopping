package com.shoppingmall.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shoppingmall.dao.ShoppingBagDao;
import com.shoppingmall.model.ShoppingBag;

public class ShoppingBagService {
	
	ShoppingBagDao dao;

	public void setDao(ShoppingBagDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<ShoppingBag> selectShoppingBag(String id){
		
		return dao.selectShoppingBag(id);
	}
	
	@Transactional
	public int deleteShoppingBag(String code){
		
		return dao.deleteShoppingBag(code);
	}
}
