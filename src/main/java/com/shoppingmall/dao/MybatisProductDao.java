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
	public Product selectOneProduct(int car_id) {
		// TODO Auto-generated method stub
		return mapper.selectOneProduct(car_id);
	}
	
	@Override
	public List<Product> selectProducts(String company, String gubun) {
		// TODO Auto-generated method stub
		return mapper.selectProducts(company, gubun);
	}

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return mapper.insertProduct(product);
	}

	@Override
	public int modifyProduct(Product product) {
		// TODO Auto-generated method stub
		return mapper.modifyProduct(product);
	}

	@Override
	public int deleteProduct(int car_id) {
		// TODO Auto-generated method stub
		return mapper.deleteProduct(car_id);
	}

	

}
