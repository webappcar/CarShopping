package com.shoppingmall.mapper;

import java.util.List;

import com.shoppingmall.model.QA;

public interface QAMapper {
	
	List<QA> selectAll();

	public int getListSize();		
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
	public void setQaRDateList(int index, String qaRDateList);
	
}
