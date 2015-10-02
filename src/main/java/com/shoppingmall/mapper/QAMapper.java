package com.shoppingmall.mapper;

import java.util.List;
import java.util.Map;

import com.shoppingmall.model.QA;
import com.shoppingmall.model.QAContent;
import com.shoppingmall.model.Sequence;

public interface QAMapper {
	
	int countAll();
	
	List<QA> selectAll();
	List<QA> selectQA(Map<String, Object> index);
	
	QA select(int writing_id);
	QA selectQAContent(int writing_id);
	QAContent selectQAById(int id);
	
	int selectQAChild(int writing_id);
	int insertQA(QA qa);
	int insertQAContentValue(QAContent qaContent);
	
	int selectMaxGroupId();
	int selectMaxOrderNo(int writing_id);
	
	void updateOrderNo(QA qa);
	
	int selectSequenceNo(String tableName);
	void updateSequence(Sequence sequence);
	void insertSequence(Sequence sequence);
	int countSequenceAll(String tableName);
	
	void updateQA(QA qa);
	void updateQAContent(QAContent qa_content);
	
	void deleteQA(int writing_id);
	
	//List<QA> select(Map<String, Object> index);

	/*public int getListSize();		
	public int getPageNum();
	public void setPageNum(int pageNum);
	
	public boolean isFirstPage();
	public void setFirstPage(boolean firstPage);
	public boolean isLastPage();
	public void setLastPage(boolean lastPage);
	
	public Integer[] getQaNoList();
	public String[] getQaTitleList();
	public String[] getQaWriterList();
	public String[] getQaRDateList();	
	
	public void setQaNoList(int index, Integer qaNoList);
	public void setQaTitleList(int index, String qaTitleList);
	public void setQaWriterList(int index, String qaWriterList);
	public void setQaRDateList(int index, String qaRDateList);*/
	
}
