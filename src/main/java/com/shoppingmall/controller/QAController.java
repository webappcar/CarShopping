package com.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/QA")
public class QAController {
	
	@RequestMapping("/list")
	public String getView() {
		
		return "qa/qa_list";
	}

}
