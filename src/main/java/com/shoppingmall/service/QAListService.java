package com.shoppingmall.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shoppingmall.dao.QaDao;
import com.shoppingmall.model.QA;

public class QAListService {

	QaDao dao;
	
	public void setMemberDao(QaDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<QA> getListAll() {

		return dao.selectAll();
	}
	
}
