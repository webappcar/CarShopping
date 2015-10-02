package com.shoppingmall.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.shoppingmall.model.QA;
import com.shoppingmall.model.QAContent;
import com.shoppingmall.model.Sequence;
import com.shoppingmall.mapper.QAMapper;

public class MybatisQaDao implements QaDao {

	static Log log = LogFactory.getLog(MybatisQaDao.class);
	
	QAMapper qaMapper;
	QaDao dao;
	
	//SequenceManager seqManager;
	Sequence sequence = new Sequence();
	
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
	public QA select(int writing_id) {
		QA list = qaMapper.select(writing_id);
		return list;
	}
	
	@Override
	public List<QA> selectQA(Map<String, Object> index) {
		List<QA> list = qaMapper.selectQA(index);
		return list;
	}
	
	@Override
	public QA selectQAContent(int writing_id) {
		QA qaContentList = qaMapper.selectQAContent(writing_id);
		
		return qaContentList;
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
	
	@Override
	public QAContent selectQAById(int id) {
		QAContent qa_content = qaMapper.selectQAById(id);
		
		return qa_content;
	}
	
	@Override
	public int selectMaxGroupId() {
		int maxGroupId = qaMapper.selectMaxGroupId();
		
		return maxGroupId;		
	}
	
	@Override
	public int selectMaxOrderNo(int writing_id) {
		int maxOrderNo = qaMapper.selectMaxOrderNo(writing_id);
		
		return maxOrderNo;		
	}
	
	@Override
	public int selectQAChild(int writing_id) {
		int isQA = qaMapper.selectQAChild(writing_id);
		
		return isQA;
	}
	
	@Override
	public int selectSequenceNo(String table_name) {
		return qaMapper.selectSequenceNo(table_name);		
	}
	
	@Override
	public void updateOrderNo(QA qa) {
		qaMapper.updateOrderNo(qa);
	}
	
	@Override
	public void updateSequence(Sequence sequence) {
		qaMapper.updateSequence(sequence);
	}
	
	@Override
	public void insertSequence(Sequence sequence) {
		qaMapper.insertSequence(sequence);
	}
	
	@Override
	public int insertQA(QA qa) {
		
		int countQA = 0;
		countQA = countAll();
		
		System.out.println("총게시물 - "+countQA);
		
		try {
			if(countQA==0) {
				qa.setGroup_id(1);
				qa.setOrder_no(0);
				qa.setParent_id(0);
				qa.setLevel_no(0);
				System.out.println("첫글...");
			} else {
				if(qa.getParent_id() == 0){//답글이 아닌경우
					int maxGroup = 0;
					maxGroup = qaMapper.selectMaxGroupId();
					maxGroup++;//그룹 번호 증가
					qa.setGroup_id(maxGroup);
					qa.setOrder_no(0);
					System.out.println("답글이 아닌경우 maxGroup = "+maxGroup);
				} else {//답글인 경우				
					int maxOrder=0;
					System.out.println("답글인 경우 qa.getParent_id() = "+qa.getParent_id());
					maxOrder = qaMapper.selectMaxOrderNo(qa.getParent_id());
					maxOrder++;
					qa.setOrder_no(maxOrder);
					System.out.println("답글인 경우 maxOrder = "+maxOrder);
				}
				if(qa.getOrder_no() > 0){//출력순서가 0이상인경우
					System.out.println("출력순서가 0이상인경우 qa.getGroup_id()="+qa.getGroup_id());
					System.out.println("출력순서가 0이상인경우 qa.getOrder_no()="+qa.getOrder_no());
					qa.setGroup_id(qa.getGroup_id());
					qa.setOrder_no(qa.getOrder_no());
					qaMapper.updateOrderNo(qa);
					System.out.println("qa.getGroup_id = "+qa.getGroup_id());
					System.out.println("qa.getOrder_no = "+qa.getOrder_no());
				}
			}
			int nextId = nextId("QA");
			System.out.println("nextId = "+nextId);
			qa.setWriting_id(nextId);
			
			System.out.println("writingId - "+qa.getWriting_id());
			System.out.println("parentId - "+qa.getParent_id());
			System.out.println("groupId - "+qa.getGroup_id());
			System.out.println("levelNo - "+qa.getLevel_no());
			System.out.println("orderNo - "+qa.getOrder_no());
			System.out.println("id - "+qa.getId());
			System.out.println("title - "+qa.getTitle());
			System.out.println("regdate - "+qa.getRegister_date());
			
			qaMapper.insertQA(qa);
		
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return 1;
	}
	
	@Override
	public int insertQAContent(QAContent qaContent, int newId) {
		
		System.out.println("writingId - "+newId);
		System.out.println("QaContent - "+qaContent.getQa_content());
		
		qaContent.setWriting_id(newId);
		qaContent.setQa_content(qaContent.getQa_content());
		
		qaMapper.insertQAContentValue(qaContent);
		
		return 1;
	}
	
	public int nextId(String tableName) {
		System.out.println("tableName = "+tableName);
		int isSequence = qaMapper.countSequenceAll(tableName);
		
		if(isSequence > 0){
			int sequence_no = qaMapper.selectSequenceNo(tableName); //최대글번호
			System.out.println("sequence_no --- "+sequence_no);
			int id = sequence_no; id++;
			System.out.println("new id = "+id);
			sequence.setSequence_no(id);
			sequence.setTable_name(tableName);
			qaMapper.updateSequence(sequence);// 마지막 번호를 1을 증가

			return id;
		}else {
			sequence.setSequence_no(1);
			sequence.setTable_name(tableName);
			qaMapper.insertSequence(sequence);

			return 1;
		}		
	}

	@Override
	public int insertQAContentValue(QAContent qaContent) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void updateQA(QA qa) {
		qaMapper.updateQA(qa);
	}
	
	@Override
	public void updateQAContent(QAContent qa_content) {
		qaMapper.updateQAContent(qa_content);
	}

	@Override
	public void deleteQA(int writing_id) {
		qaMapper.deleteQA(writing_id);		
	}

	@Override
	public int countSequenceAll(String tableName) {
		int countSequence = qaMapper.countSequenceAll(tableName);
		return countSequence;
	}

	
/*	

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
