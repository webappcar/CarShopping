package com.shoppingmall.mapper;

import java.util.List;
import java.util.Map;

import com.shoppingmall.model.Member;

public interface MemberMapper {

	List<Member> selectAll();
	List<Member> select(Map<String, Object> index);
	
	Member selectById(String id);
	Member selectByEmail(String email);
	
	int selectTotalCount();
	
	int insert(Member member);
	int insertGenerator(Member member);
	
	int update(Member member);
	
	int deleteById(String id);
	int deleteByEmail(String email);
}
