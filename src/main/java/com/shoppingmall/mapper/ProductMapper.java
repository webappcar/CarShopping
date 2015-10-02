package com.shoppingmall.mapper;

import java.util.List;

import com.shoppingmall.model.Product;

public interface ProductMapper {
	
	List<Product> selectProduct();
	Product selectOneProduct(int car_id);
	List<Product> selectProducts(String company, String gubun);
	int insertProduct(Product product);
	int modifyProduct(Product product);
}
