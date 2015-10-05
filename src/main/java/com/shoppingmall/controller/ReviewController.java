package com.shoppingmall.controller;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingmall.dao.MybatisReviewDao;
import com.shoppingmall.model.QA;
import com.shoppingmall.model.QAContent;
import com.shoppingmall.model.Review;
import com.shoppingmall.model.ReviewContent;
import com.shoppingmall.service.QAListService;
import com.shoppingmall.service.QAWritingService;
import com.shoppingmall.util.ImageUtil;
import com.shoppingmall.util.MultipartUploading;
import com.shoppingmall.util.SequenceManager;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	static Log log = LogFactory.getLog(ReviewController.class);
	static int PAGE_SIZE = 10;
	
	@Autowired
	MybatisReviewDao reviewDao;
	
	@RequestMapping("/view/{article_num}")
	public String getView(@PathVariable String article_num, Model model) {

		System.out.println(article_num+", "+article_num);
		
		int writing_id = Integer.parseInt(article_num);
		
		Review review = reviewDao.selectReview(writing_id);
		ReviewContent reviewContent = reviewDao.selectReviewContent(writing_id);
		
		model.addAttribute("review", review);
		model.addAttribute("reviewContent", reviewContent);
		
		return "review/review_view";
	}
	
	@RequestMapping("/write/{car_id}")
	public String writeReview(@PathVariable String car_id, Model model) {
		
		model.addAttribute("car_id", car_id);
		
		return "review/review_write";
	}
	
	@RequestMapping("/insert")
	public String reviewInsert(Model model, HttpServletRequest request) throws Exception {
		String user_id= request.getParameter("user_id");
		String car_id= request.getParameter("car_id");
		String review_title = request.getParameter("review_title");
		String review_content=request.getParameter("review_content");
	
		System.out.println("user_id - "+user_id);
		System.out.println("car_id - "+car_id);
		System.out.println("review_title - "+review_title);
		System.out.println("review_content - "+review_content);
		
		try {
			Review review = new Review();
			ReviewContent reviewContent = new ReviewContent();
			
			review.setCode(car_id);
			review.setId(user_id);
			review.setNickname("");
			review.setTitle(review_title);
			
			GregorianCalendar gc = new GregorianCalendar();
			String today = gc.get(Calendar.YEAR) + "/" + (gc.get(Calendar.MONTH)+1) + "/" + gc.get(Calendar.DATE);
			
			review.setRegister_date(today);
						
			int insertReviewResult = reviewDao.insertReview(review);
			System.out.println("new_writing_id = "+review.getWriting_id());
			
			reviewContent.setReview_content(review_content);
			reviewContent.setWriting_id(review.getWriting_id());
			int insertContentResult = reviewDao.insertReviewContent(reviewContent);
			
			System.out.println("insertReviewResult = "+insertReviewResult);
			System.out.println("insertContentResult = "+insertContentResult);
		} catch(Exception e){
			e.printStackTrace();			
		}

		return "review/review_write_result";
	}
	
	@RequestMapping("/update/{article_num}")
	public String getUpdateForm(@PathVariable String article_num, @RequestParam("pageNo") String pageNo, Model model) {
	
/*		System.out.println(article_num+", "+pageNo);
		
		int id = Integer.parseInt(article_num);
		
		QA qaContentList = writingService.selectContentQA(id);
		QAContent qaContent = writingService.selectQA(id);
		
		model.addAttribute("qaContentList", qaContentList);
		model.addAttribute("qaContent", qaContent);
		model.addAttribute("pageNo", pageNo);	*/
		
		return "review/review_update";
	}
	
	@RequestMapping("/updateReview")
	public String qaUpdate(Model model, HttpServletRequest request) {
	/*	String pageNo= request.getParameter("pageNo");
		String writing_id= request.getParameter("writing_id");
		String qa_title = request.getParameter("qa_title");
		String qa_content=request.getParameter("qa_content");
		
		System.out.println("pageNo - "+pageNo);
		System.out.println("writing_id - "+writing_id);
		System.out.println("qa_title - "+qa_title);
		System.out.println("qa_content - "+qa_content);
		
		model.addAttribute("pageNo", pageNo);
		
		QA qa = new QA();
		QAContent qaContent = new QAContent();
		
		qa.setWriting_id(Integer.parseInt(writing_id));
		qa.setTitle(qa_title);
		
		qaContent.setWriting_id(Integer.parseInt(writing_id));
		qaContent.setQa_content(qa_content);
		
		writingService.updateQA(qa);
		writingService.updateQAContent(qaContent);		*/
	
		return "review/review_update_result";
	}
	
	@RequestMapping("/delete/{article_num}")
	public String confirmDelete(@PathVariable String article_num, @RequestParam("pageNo") String pageNo, Model model) {
	
/*		System.out.println(article_num+", "+pageNo);
		
		int id = Integer.parseInt(article_num);
		
		QA qaContentList = writingService.selectContentQA(id);
		QAContent qaContent = writingService.selectQA(id);
		
		model.addAttribute("qaContentList", qaContentList);
		model.addAttribute("qaContent", qaContent);
		model.addAttribute("pageNo", pageNo);	*/
		
		return "review/review_delete";
	}
	
	@RequestMapping("/deleteReview")
	public String qaDelete(Model model, HttpServletRequest request) {
/*		String pageNo= request.getParameter("pageNo");
		String writing_id= request.getParameter("writing_id");
		
		System.out.println("pageNo - "+pageNo);
		System.out.println("writing_id - "+writing_id);
		
		int id = Integer.parseInt(writing_id);
		int isChild = 0;
		isChild = writingService.selectQAChild(id);
		
		if(isChild==0) {
			writingService.deleteQA(id);
		} else {
			System.out.println("답글있음");
		}
		
		System.out.println("isChild - "+isChild);
		
		model.addAttribute("isChild", isChild);
		model.addAttribute("pageNo", pageNo);*/
		
		return "review/review_delete_result";
	}
	

}
