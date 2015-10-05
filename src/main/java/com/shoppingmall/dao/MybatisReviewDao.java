package com.shoppingmall.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.shoppingmall.model.Review;
import com.shoppingmall.model.ReviewContent;
import com.shoppingmall.model.Sequence;
import com.shoppingmall.mapper.QAMapper;
import com.shoppingmall.mapper.ReviewMapper;

public class MybatisReviewDao implements ReviewMapper {

	static Log log = LogFactory.getLog(MybatisReviewDao.class);
	
	ReviewMapper reviewMapper;
	
	public void setReviewMapper(ReviewMapper mapper) {
		reviewMapper = mapper;
	}
	
	Sequence sequence = new Sequence();
	
	public Review selectReview(int writing_id) {
		Review review = reviewMapper.selectReview(writing_id);
		
		return review;
	}
	
	public ReviewContent selectReviewContent(int writing_id) {
		ReviewContent reviewContent = reviewMapper.selectReviewContent(writing_id);
		
		return reviewContent;
	}
	
	public int insertReview(Review review) {
		
		int nextId = nextId("Review");
		System.out.println("nextId = "+nextId);
		review.setWriting_id(nextId);
		
		reviewMapper.insertReview(review);
		
		return 1;
	}
	
	public int insertReviewContent(ReviewContent review_content) {
		
		System.out.println("writing_id4content - "+review_content.getWriting_id());
		System.out.println("ReviewContent - "+review_content.getReview_content());
		
		reviewMapper.insertReviewContent(review_content);
		
		return 1;
	}
	
	public void updateReview(Review review) {
		reviewMapper.updateReview(review);
	}
	
	public void updateReviewContent(ReviewContent review_content) {
		reviewMapper.updateReviewContent(review_content);
	}
	
	public void deleteReview(int writing_id) {
		reviewMapper.deleteReview(writing_id);
	}
	
	@Override
	public int selectSequenceNo(String table_name) {
		return reviewMapper.selectSequenceNo(table_name);		
	}
	
	@Override
	public void updateSequence(Sequence sequence) {
		reviewMapper.updateSequence(sequence);
	}
	
	@Override
	public void insertSequence(Sequence sequence) {
		reviewMapper.insertSequence(sequence);
	}
	
	@Override
	public int countSequenceAll(String tableName) {
		return 0;
	}
	
	public int nextId(String tableName) {
		System.out.println("tableName = "+tableName);
		int isSequence = reviewMapper.countSequenceAll(tableName);
		
		if(isSequence > 0){
			int sequence_no = reviewMapper.selectSequenceNo(tableName); //최대글번호
			System.out.println("sequence_no --- "+sequence_no);
			int id = sequence_no; id++;
			System.out.println("new id = "+id);
			sequence.setSequence_no(id);
			sequence.setTable_name(tableName);
			reviewMapper.updateSequence(sequence);// 마지막 번호를 1을 증가

			return id;
		}else {
			sequence.setSequence_no(1);
			sequence.setTable_name(tableName);
			reviewMapper.insertSequence(sequence);

			return 1;
		}		
	}

}
