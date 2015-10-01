package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.QAMapper;
import com.shoppingmall.model.QA;

public interface QaDao extends QAMapper {
	
	//List<QA> select(int firstItem, int lastItem);
	List<QA> selectQA(int firstItem, int lastItem);
	
	/*
	 * QA DML
	 */
/*	static final String SELECT_QA =
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

	static final String SELECT_BY_ID = SELECT_QA +
						"  where writing_id = ?     ";
	
	static final String INSERT_QA =
						"	insert into qa  " +
						"	(                  " +
						"		writing_id,    " +
						"        group_id,     " +
						"	     order_no,     " +
						"        level_no,     " +
						"	     parent_id,    " +			
						"        id,     	   " +
						"	     title, 	   " +						
						"	     register_date " +
						"	)                   " +
						"	values              " +
						"	(                   " +
						"		?,              " +		// #{writing_id}
						"		?,              " +		// #{group_id}
						"		?,              " +		// #{order_no}
						"		?,              " +		// #{level_no}
						"		?,              " +		// #{parent_id}
						"		?,              " +		// #{user_id}
						"		?,              " +		// #{title}
						"		?               " +		// #{register_date}						
						"	)                   ";
	
	static final String DELETE_QA = " delete from qa ";
	
	static final String DELETE_QA_BY_ID = 
						DELETE_QA +
						" where writing_id = ?";
*/	
	
	static final String SELECT_QA = "";
	static final String SELECT_ALL = "";
	static final String SELECT_BY_ID = "";
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
