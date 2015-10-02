package com.shoppingmall.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.shoppingmall.dao.QaDao;
import com.shoppingmall.model.QA;
import com.shoppingmall.model.QAContent;

public class QAWritingService {
	
	QaDao dao;
	
	public int countAll() {
		return dao.countAll();
	}
	
	public void setQaDao(QaDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public QA selectContentQA(int id) {
		
		return dao.selectQAContent(id);
	}
	
	@Transactional
	public QAContent selectQA(int id) {
		
		return dao.selectQAById(id);
	}
	
	@Transactional
	public int selectQAChild(int id) {
		
		return dao.selectQAChild(id);
	}
	
	@Transactional
	public int insertQA(QA qa) {
		
		return dao.insertQA(qa);
	}
	
	@Transactional
	public int insertQAContent(QAContent qaContent, int newId) {
		
		return dao.insertQAContent(qaContent, newId);				
	}
	
	@Transactional
	public void updateQA(QA qa) {
		dao.updateQA(qa);
	}
	
	@Transactional
	public void updateQAContent(QAContent qa_content) {
		dao.updateQAContent(qa_content);
	}
	
	@Transactional
	public void deleteQA(int writing_id) {
		dao.deleteQA(writing_id);
	}

}
