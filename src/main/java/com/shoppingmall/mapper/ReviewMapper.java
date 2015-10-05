package com.shoppingmall.mapper;

import com.shoppingmall.model.Review;
import com.shoppingmall.model.ReviewContent;
import com.shoppingmall.model.Sequence;

public interface ReviewMapper {
	
	Review selectReview(int writing_id);
	ReviewContent selectReviewContent(int writing_id);
	
	int insertReview(Review review);
	int insertReviewContent(ReviewContent review_content);	
	
	void updateReview(Review review);
	void updateReviewContent(ReviewContent review_content);
	
	void deleteReview(int writing_id);
	
	int selectSequenceNo(String tableName);
	void updateSequence(Sequence sequence);
	void insertSequence(Sequence sequence);
	int countSequenceAll(String tableName);
	
}
