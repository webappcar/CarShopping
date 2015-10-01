package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.ProductMapper;
import com.shoppingmall.model.Product;

public class MybatisProductDao implements ProductDao{

	ProductMapper mapper;
	
	public void setProductMapper(ProductMapper mapper){
		this.mapper = mapper;
	}
	
	@Override
	public List<Product> selectProduct() {
		// TODO Auto-generated method stub
		return mapper.selectProduct();
	}

	@Override
	public List<Product> selectProducts(String company, String gubun) {
		// TODO Auto-generated method stub
		return mapper.selectProducts(company, gubun);
	}

}
