package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.ProductMapper;
import com.shoppingmall.model.Product;

public interface ProductDao extends ProductMapper{

	List<Product> selectProduct();
	List<Product> selectProducts(String company, String gubun);
	int insertProduct(Product product);
}
