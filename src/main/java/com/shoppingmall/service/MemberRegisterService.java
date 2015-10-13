package com.shoppingmall.service;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingmall.dao.MemberDao;
import com.shoppingmall.exception.AlreadyExistingMemberException;
import com.shoppingmall.model.Member;

public class MemberRegisterService {

	MemberDao memberDao;
	
	public void setMemberDao(MemberDao dao) {
		this.memberDao = dao;
	}
	
	@Transactional
	public void register(Member member) {
		try {
			memberDao.insert(member);
//			memberDao.insertGenerator(member);
		} catch (DuplicateKeyException e) {
			throw new AlreadyExistingMemberException(e);
		}
	}
	
	@Transactional
	public void update(Member member) {
		memberDao.update(member);
	}
}


