package com.shoppingmall.service;

import java.util.List;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingmall.dao.MemberDao;
import com.shoppingmall.model.Member;
import com.shoppingmall.model.MemberList;

public class MemberListService {

	MemberDao dao;
	
	public void setMemberDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public List<Member> getListAll() {

		return dao.selectAll();
	}
	
	@Transactional
	public Member getSelectById(String id) {

		return dao.selectById(id);
	}
	
	PlatformTransactionManager tm;
	
	/*@Transactional(isolation=Isolation.READ_COMMITTED,
				   propagation=Propagation.REQUIRED,
				   readOnly=true,
				   rollbackFor=Exception.class)
	public MemberList getList(int pageNo) {
		MemberList paging = new MemberList();
		
		int totalItem = dao.selectTotalCount();
		paging.setTotalItem(totalItem);
		paging.setPageNo(pageNo);
		
		int firstItem = paging.getFirstItem();
		int lastItem = paging.getLastItem();
		
		List<Member> members = dao.select(firstItem, lastItem);
		paging.setMembers(members);
		
		return paging;
	}*/
	
}
