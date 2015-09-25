package com.shoppingmall.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shoppingmall.dao.QaDao;
import com.shoppingmall.model.QA;

public class QAListService {

	QaDao dao;
	
	public void setQaDao(QaDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public int getListTotal() {
	
		return dao.countAll();
	}
	
	@Transactional
	public List<QA> getList(int firstItem, int lastItem) {
		System.out.println("firstItem = " + firstItem + ", " + "lastItem = " + lastItem);
		return dao.selectQA(firstItem, lastItem);
	}
	
	@Transactional
	public List<QA> getListAll() {
		
		return dao.selectAll();
	}
	
}
