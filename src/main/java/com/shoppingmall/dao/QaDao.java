package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.QAMapper;
import com.shoppingmall.model.QA;
import com.shoppingmall.model.QAContent;
import com.shoppingmall.model.Sequence;

public interface QaDao extends QAMapper {
	
	List<QA> selectQA(int firstItem, int lastItem);	// 리스트용
	QA select(int writing_id);
	QA selectQAContent(int writing_id);		// 본문용
	
	QAContent selectQAById(int id);
	int selectQAChild(int writing_id);
	
	int insertQA(QA qa);
	int insertQAContent(QAContent qaContent, int newId);
	int insertQAContentValue(QAContent qaContent);
	
	int selectMaxGroupId();
	int selectMaxOrderNo(int writing_id);
	
	void updateOrderNo(QA qa);
	
	int selectSequenceNo(String tableName);
	void updateSequence(Sequence sequence);
	void insertSequence(Sequence sequence);
	int countSequenceAll(String tableName);
	
	void deleteQA(int writing_id);
	
	/*
	 * QA DML
	 */
	static final String SELECT_QA =
						" select writing_id,   " + 
						"        group_id,     " +
						"	     order_no,     " +
						"        level_no,     " +
						"	     parent_id,    " +			
						"        id,     	   " +
						"	     title, 	   " +						
						"	     register_date " +
						"   from qa     ";
	
	static final String SELECT_ALL = SELECT_QA;

	static final String SELECT_BY_ID = SELECT_QA + " where writing_id = ?";
	static final String INSERT_QA = "";
	static final String DELETE_QA = "";
	static final String DELETE_QA_BY_ID = "";
	
	static final String PAGING_ORACLE = 
			" select writing_id,group_id,order_no,level_no,parent_id,id,title,register_date,name,rn from " + 
			"	(select a.*, rownum rn from " + 
			"		(select a.*, b.name from qa a, user_info b " + 
			" where a.id=b.id order by group_id desc, order_no asc)	a) " +
			" where rn between ? " +// #{firstItem}
			" and ?";// #{lastItem}
}
