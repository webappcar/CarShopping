package com.shoppingmall.mapper;

import java.util.List;
import java.util.Map;

import com.shoppingmall.model.QA;
import com.shoppingmall.model.QAContent;

public interface QAMapper {
	
	int countAll();
	
	List<QA> selectAll();
	List<QA> selectQA(Map<String, Object> index);
	
	QA select(int writing_id);
	QA selectQAContent(int writing_id);
	QAContent selectQAById(int id);
	
	int insertQA(QA qa, QAContent qaContent);
	
	int selectMaxGroupId();
	int selectMaxOrderNo(int writing_id);
	
	void updateOrderNo(int group_id, int order_no);
	
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
