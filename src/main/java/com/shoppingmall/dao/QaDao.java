package com.shoppingmall.dao;

import java.util.List;

import com.shoppingmall.mapper.QAMapper;
import com.shoppingmall.model.QA;

public interface QaDao extends QAMapper {
	
	List<QA> select(int firstItem, int lastItem);
	
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
	
	static final String DELETE = " delete from qa ";
	
	static final String DELETE_BY_ID = 
						DELETE +
						" where writing_id = ?";
}
