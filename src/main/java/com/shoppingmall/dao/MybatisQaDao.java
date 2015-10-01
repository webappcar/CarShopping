package com.shoppingmall.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import com.shoppingmall.mapper.IdGeneratorMapper;
import com.shoppingmall.mapper.MemberMapper;
import com.shoppingmall.mapper.QAMapper;
import com.shoppingmall.model.Member;
import com.shoppingmall.model.QA;
import com.shoppingmall.util.Password;

public class MybatisQaDao implements QaDao {

	static Log log = LogFactory.getLog(MybatisQaDao.class);
	
	QAMapper qaMapper;
	
	public void setQaMapper(QAMapper mapper) {
		qaMapper = mapper;
	}
	
	@Override
	public int countAll() {

		return qaMapper.countAll();
	}
	
	@Override
	public List<QA> selectAll() {
		return qaMapper.selectAll();
	}
	
	@Override
	public List<QA> selectQA(Map<String, Object> index) {
		List<QA> list = qaMapper.selectQA(index);
		return list;
	}

	@Override
	public List<QA> selectQA(int firstItem, int lastItem) {
		Map<String, Object> index = new HashMap<String, Object>();
		index.put("firstItem", firstItem);
		index.put("lastItem", lastItem);
		int offset = firstItem - 1;
		int count = lastItem - firstItem + 1;
		index.put("offset", offset);
		index.put("count", count);
		
		return this.selectQA(index);
	}
	
/*	@Override
	public List<QA> select(Map<String, Object> index) {
		List<QA> list = qaMapper.select(index);
		return list;
	}

	@Override
	public List<QA> select(int firstItem, int lastItem) {
		Map<String, Object> index = new HashMap<String, Object>();
		index.put("firstItem", firstItem);
		index.put("lastItem", lastItem);
		int offset = firstItem - 1;
		int count = lastItem - firstItem + 1;
		index.put("offset", offset);
		index.put("count", count);
		
		return this.select(index);
	}*/


	/*
	@Override
	public Member selectById(String id) {
		Member m = memberMapper.selectById(id);
		if (m == null) 
			throw new EmptyResultDataAccessException(id + "", 1);
		return m;
	}

	@Override
	public Member selectByEmail(String email) {
		Member m = memberMapper.selectByEmail(email);
		if (m == null) 
			throw new EmptyResultDataAccessException(email, 1);
		return m;
	}
	
	@Override
	public int selectTotalCount() {

		return qaMapper.selectTotalCount();
	}
	

	@Override
	public int insert(Member member) {
		
		int rtn=0;
		member.setPassword(Password.encode(member.getPassword()));
		
		if (useGeneratorTable) {
			Map<String, Object> idGen = idGeneratorMapper.selectByName("memberId");
			int nextval = ((BigDecimal)idGen.get("nextval")).intValue();
			int incval = ((BigDecimal)idGen.get("incval")).intValue();
			int seq = nextval + incval;
			idGen.put("nextval", seq);
			idGeneratorMapper.update(idGen);
			
			//member.setId(seq);
			rtn = memberMapper.insertGenerator(member);
			
		} else {
			rtn = memberMapper.insert(member);
		}
		
		return rtn;
	}

	@Override
	public int insertGenerator(Member member) {
		Assert.isTrue(false, "deprecated...");
		return 0;
	}

	@Override
	public int update(Member member) {
		int rtn = memberMapper.update(member);
		if (rtn != 1) {
			throw new JdbcUpdateAffectedIncorrectNumberOfRowsException("invalid update", 1, rtn);
		}
		return rtn;
	}

	@Override
	public int deleteById(String id) {
		int rtn = memberMapper.deleteById(id);
		if (rtn != 1) {
			throw new JdbcUpdateAffectedIncorrectNumberOfRowsException(id + "", 1, rtn);
		}
		return rtn;
	}

	@Override
	public int deleteByEmail(String email) {
		int rtn = memberMapper.deleteByEmail(email);
		if (rtn != 1) {
			throw new JdbcUpdateAffectedIncorrectNumberOfRowsException(email, 1, rtn);
		}
		return rtn;
	}

	@Override
	public Member selectByEmailWithPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByIdWithEmail(int id, String email) {
		// TODO Auto-generated method stub
		
	}


*/


}
