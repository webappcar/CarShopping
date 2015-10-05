package com.shoppingmall.model;

public class ReviewContent {
	
	private int writing_id;			// size=5
 	private String review_content;	// size = 500
 	
	public int getWriting_id() {
		return writing_id;
	}
	public void setWriting_id(int writing_id) {
		this.writing_id = writing_id;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

}
