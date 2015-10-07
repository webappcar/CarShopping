package com.shoppingmall.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shoppingmall.dao.PurchaseDao;
import com.shoppingmall.model.Purchase;

public class PurchaseService {
	
	PurchaseDao dao;
	
	public void setPurchaseDao(PurchaseDao dao){
		this.dao = dao;
	}
	
	@Transactional
	public List<Purchase> purchaseSelect(){
		
		return dao.purchaseSelect();
	}
	
	@Transactional
	public Purchase purchaseSelectOne(String purchase_no){
		
		return dao.purchaseSelectOne(purchase_no);
	}
	
	@Transactional
	public List<Purchase> purchaseSelectOneId(String id){
		
		return dao.purchaseSelectOneId(id);
	}
	
	@Transactional
	public int purchaseInsert(Purchase purchase){
		
		return dao.purchaseInsert(purchase);
	}
	
	@Transactional
	public int purchaseUpdate(Purchase purchase){
		
		return dao.purchaseUpdate(purchase);
	}
	
	@Transactional
	public int purchaseDelete(String purchase_no){
		
		return dao.purchaseDelete(purchase_no);
	}
}
