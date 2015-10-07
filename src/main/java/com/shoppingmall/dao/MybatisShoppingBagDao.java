package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.ShoppingBagMapper;
import com.shoppingmall.model.ShoppingBag;

public class MybatisShoppingBagDao implements ShoppingBagDao{

	ShoppingBagMapper mapper;
	
	public void setMapper(ShoppingBagMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<ShoppingBag> selectShoppingBag(String id) {
		// TODO Auto-generated method stub
		return mapper.selectShoppingBag(id);
	}

	@Override
	public int deleteShoppingBag(String code) {
		// TODO Auto-generated method stub
		return mapper.deleteShoppingBag(code);
	}

}
