package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.PurchaseMapper;
import com.shoppingmall.model.Purchase;

public class MybatisPurchaseDao implements PurchaseDao{

	PurchaseMapper mapper;
	
	public void setPurchaseMapper(PurchaseMapper mapper){
		this.mapper = mapper;
	}
	
	@Override
	public List<Purchase> purchaseSelect() {
		// TODO Auto-generated method stub
		return mapper.purchaseSelect();
	}

	@Override
	public Purchase purchaseSelectOne(String purchase_no) {
		// TODO Auto-generated method stub
		return mapper.purchaseSelectOne(purchase_no);
	}

	@Override
	public List<Purchase> purchaseSelectOneId(String id) {
		// TODO Auto-generated method stub
		return mapper.purchaseSelectOneId(id);
	}

	@Override
	public int purchaseInsert(Purchase purchase) {
		// TODO Auto-generated method stub
		System.out.println("purchase : Mybatispurchase DAO");
		return mapper.purchaseInsert(purchase);
	}

	@Override
	public int purchaseUpdate(Purchase purchase) {
		// TODO Auto-generated method stub
		return mapper.purchaseUpdate(purchase);
	}

	@Override
	public int purchaseDelete(String purchase_no) {
		// TODO Auto-generated method stub
		return mapper.purchaseDelete(purchase_no);
	}

	
}
