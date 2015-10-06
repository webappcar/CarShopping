package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.ProductMapper;
import com.shoppingmall.model.Product;

public interface ProductDao extends ProductMapper{

	List<Product> selectProduct();
	Product selectOneProduct(int car_id);
	List<Product> selectProducts(String company, String gubun);
	int insertProduct(Product product);
	int modifyProduct(Product product);
	int deleteProduct(int car_id);
	List<Product> selectHotItemProduct();
	List<Product> selectNewItemProduct();
}
