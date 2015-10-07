package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.PurchaseMapper;
import com.shoppingmall.model.Purchase;

public interface PurchaseDao extends PurchaseMapper{
	List<Purchase> purchaseSelect();
	Purchase purchaseSelectOne(String purchase_no);
	List<Purchase> purchaseSelectOneId(String id);
	int purchaseInsert(Purchase purchase);
	int purchaseUpdate(Purchase purchase);
	int purchaseDelete(String purchase_no);
}
