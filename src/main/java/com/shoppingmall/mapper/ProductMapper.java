package com.shoppingmall.mapper;

import java.util.List;

import com.shoppingmall.model.Product;

public interface ProductMapper {
	
	List<Product> selectProduct();
	List<Product> selectProducts(String company, String gubun);
//	int insertProduct();
//	int modifyProduct();
}
