package com.shoppingmall.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shoppingmall.model.QA;
import com.shoppingmall.model.QAContent;
import com.shoppingmall.service.QAListService;
import com.shoppingmall.service.QAWritingService;

@Controller
@RequestMapping("/qa")
public class QAController {
	
	static Log log = LogFactory.getLog(QAController.class);
	static int PAGE_SIZE = 10;
	
	@Autowired
	QAListService listService;
	
	@Autowired
	QAWritingService writingService;
	
	@RequestMapping("/list/{pageNo}")
	public String getList(@PathVariable String pageNo, Model model) {
		log.info("getList()...page = "+pageNo);
		
		int currentPage = Integer.parseInt(pageNo);
		
		int count = listService.getListTotal();
		int totalPageCount = 0;
		int startRow = 0, endRow = 0;
		
		if(count > 0) {
			totalPageCount = count / PAGE_SIZE;
			if(count % PAGE_SIZE > 0) totalPageCount++;
			startRow = (currentPage - 1) * PAGE_SIZE + 1;
			endRow = currentPage * PAGE_SIZE;
		}
		
		int number = count - (currentPage-1)*10 + 1;
		
		List<QA> qalist = listService.getList(startRow, endRow);
				
		model.addAttribute("qalist", qalist);			
	    model.addAttribute("pageNo", pageNo);	
	    model.addAttribute("count", count);
	    model.addAttribute("number", number);
	    
	    model.addAttribute("startRow", startRow);
	    model.addAttribute("endRow", endRow);		
		
		return "qa/qa_list";
	}
	
	@RequestMapping("/view/{article_num}")
	public String getView(@PathVariable String article_num, @RequestParam("pageNo") String pageNo, Model model) {
	//@RequestParam("pageNo") String pageNo, //required 조건이 없으면 기본값은 true, 즉 필수 파라미터 이다. 파라미터 pageNo가 존재하지 않으면 Exception 발생.
	//@RequestParam(value="pageNo", required=false) String pageNo){ //파라미터 pageNo가 존재하지 않으면 String pageNo는 null.

		System.out.println(article_num+", "+pageNo);
		
		int id = Integer.parseInt(article_num);
		
		QA qaContentList = writingService.selectContentQA(id);
		QAContent qaContent = writingService.selectQA(id);
		
		model.addAttribute("qaContentList", qaContentList);
		model.addAttribute("qaContent", qaContent);
		model.addAttribute("pageNo", pageNo);	
		
		return "qa/qa_view";
	}
	
	@RequestMapping("/write")
	public String writeQA(@RequestParam("pageNo") String pageNo, @RequestParam(value="parent_id", required=false) String parent_id, Model model) {
		
		QA parentList = null;
		String title = "";
		
		if(parent_id != null){
			parentList = listService.getSelect(Integer.parseInt(parent_id));
			if(parentList != null){
				title = "[re:] " + parentList.getTitle();
			}
		}
		
		model.addAttribute("parentList", parentList);
		model.addAttribute("title", title);
		
		model.addAttribute("parent_id", parent_id);
		model.addAttribute("pageNo", pageNo);
		
		return "qa/qa_write";
	}
	
	@RequestMapping("/insert")
	public String qaInsert(Model model, HttpServletRequest request) throws Exception {
		String pageNo= request.getParameter("pageNo");
		String parentId= request.getParameter("parent_id");
		String groupId = request.getParameter("group_id");
		String levelNo=request.getParameter("level_no");
		String orderNo=request.getParameter("order_no");
		
		System.out.println("pageNo - "+pageNo);
		System.out.println("parentId - "+parentId);
		System.out.println("groupId - "+groupId);
		System.out.println("levelNo - "+levelNo);
		System.out.println("orderNo - "+orderNo);
		
		model.addAttribute("pageNo", pageNo);
		
		try {
			QA qa = new QA();
			QAContent qaContent = new QAContent();
			
			if(parentId ==  null){//원글이기 때문에 부모번호없음(0)
				qa.setParent_id(0);
				qa.setGroup_id(0);//나중에 1이 증가함
				qa.setLevel_no(0);
				qa.setOrder_no(0);
			}else{
				qa.setParent_id(Integer.parseInt(parentId));
				qa.setGroup_id(Integer.parseInt(groupId));
				qa.setLevel_no(Integer.parseInt(levelNo));
				qa.setOrder_no(Integer.parseInt(orderNo));
			}
			
			GregorianCalendar gc = new GregorianCalendar();
			String today = gc.get(Calendar.YEAR) + "/" + (gc.get(Calendar.MONTH)+1) + "/" + gc.get(Calendar.DATE);
			
			qa.setRegister_date(today);
			
			System.out.println("qa_title = "+request.getParameter("qa_title"));
			System.out.println("qa_content = "+request.getParameter("qa_content"));
			System.out.println("today = "+today);
			
			qa.setId(request.getParameter("userId"));
			//qa.setId("goodmv");
			qa.setTitle(request.getParameter("qa_title"));
			qaContent.setQa_content(request.getParameter("qa_content"));
			
			int insertQaResult = writingService.insertQA(qa);
			System.out.println("new_writing_id = "+qa.getWriting_id());
			int insertContentResult = writingService.insertQAContent(qaContent, qa.getWriting_id());
			
			System.out.println("insertQaResult = "+insertQaResult);
			System.out.println("insertContentResult = "+insertContentResult);
		} catch(Exception e){
			e.printStackTrace();			
		}

		return "qa/qa_write_result";
	}
	
	@RequestMapping("/update/{article_num}")
	public String getUpdateForm(@PathVariable String article_num, @RequestParam("pageNo") String pageNo, Model model) {
	
		System.out.println(article_num+", "+pageNo);
		
		int id = Integer.parseInt(article_num);
		
		QA qaContentList = writingService.selectContentQA(id);
		QAContent qaContent = writingService.selectQA(id);
		
		model.addAttribute("qaContentList", qaContentList);
		model.addAttribute("qaContent", qaContent);
		model.addAttribute("pageNo", pageNo);	
		
		return "qa/qa_update";
	}
	
	@RequestMapping("/updateQA")
	public String qaUpdate(Model model, HttpServletRequest request) {
		String pageNo= request.getParameter("pageNo");
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
		writingService.updateQAContent(qaContent);		
	
		return "qa/qa_update_result";
	}
	
	@RequestMapping("/delete/{article_num}")
	public String confirmDelete(@PathVariable String article_num, @RequestParam("pageNo") String pageNo, Model model) {
	
		System.out.println(article_num+", "+pageNo);
		
		int id = Integer.parseInt(article_num);
		
		QA qaContentList = writingService.selectContentQA(id);
		QAContent qaContent = writingService.selectQA(id);
		
		model.addAttribute("qaContentList", qaContentList);
		model.addAttribute("qaContent", qaContent);
		model.addAttribute("pageNo", pageNo);	
		
		return "qa/qa_delete";
	}
	
	@RequestMapping("/deleteQA")
	public String qaDelete(Model model, HttpServletRequest request) {
		String pageNo= request.getParameter("pageNo");
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
		model.addAttribute("pageNo", pageNo);
		
		return "qa/qa_delete_result";
	}

}
