package com.shoppingmall.mapper;

import java.util.List;

import com.shoppingmall.model.ShoppingBag;

public interface ShoppingBagMapper {
	List<ShoppingBag> selectShoppingBag(String id);
	int deleteShoppingBag(String id);
}
