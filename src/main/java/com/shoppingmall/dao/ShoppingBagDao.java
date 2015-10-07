package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.ShoppingBagMapper;
import com.shoppingmall.model.ShoppingBag;

public interface ShoppingBagDao extends ShoppingBagMapper{
	List<ShoppingBag> selectShoppingBag(String id);
	int deleteShoppingBag(String code);
}
