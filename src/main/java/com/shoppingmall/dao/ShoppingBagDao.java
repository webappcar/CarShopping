package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.model.ShoppingBag;

public interface ShoppingBagDao{
	List<ShoppingBag> selectShoppingBag(String id);
	int deleteShoppingBag(String id);
}
