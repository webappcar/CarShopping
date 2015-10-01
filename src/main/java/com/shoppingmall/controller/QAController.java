package com.shoppingmall.controller;

import java.util.List;

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

import com.shoppingmall.model.QA;
import com.shoppingmall.service.QAListService;

@Controller
@RequestMapping("/qa")
public class QAController {
	
	static Log log = LogFactory.getLog(QAController.class);
	static int PAGE_SIZE = 10;
	
	@Autowired
	QAListService listService;
	
	@RequestMapping("/list/{page}")
	public String getList1(@PathVariable String page, Model model) {
		log.info("getList()...page = "+page);
		
		int currentPage = Integer.parseInt(page);
		
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
		
		
	    model.addAttribute("page", page);	
	    model.addAttribute("count", count);
	    model.addAttribute("number", number);
	    
	    model.addAttribute("startRow", startRow);
	    model.addAttribute("endRow", endRow);
		
		
		
		return "qa/qa_list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/list3")
	public String getList(@RequestParam String pageNo, Model model, HttpServletRequest request) {
		
		int count = listService.getListTotal();
		//String pageNo = page;
		
/*	    model.addAttribute("page", page);
	    model.addAttribute("count", count);*/
	    
	    request.setAttribute("count", count);
	    request.setAttribute("pageNo", pageNo);
	    
	    List<QA> qalist = listService.getList(2,4);
		
		model.addAttribute("qalist", qalist);
	    
	    return "qa/qa_list";
	}
	
	
	@RequestMapping(value="/list2", method = RequestMethod.POST)
    public ModelAndView postComment(HttpServletRequest req, @RequestParam String page) {
		int count = listService.getListTotal();
		
        ModelAndView result = new ModelAndView("qa/qa_list");
        
        result.addObject("page", page);
        result.addObject("count", count);
        
        List<QA> qalist = listService.getList(2,4);
        
        result.addObject("qalist", qalist);
        
        return result;
    }

	
	
	@RequestMapping("/view")
	public String getView() {
		
		return "qa/qa_view";
	}

}
