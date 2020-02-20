package com.litao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.litao.entity.Article;
import com.litao.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("list")
	public String list(String start,String end,String select,@RequestParam(defaultValue="1")Integer pageNum,Model model) {
		PageInfo<Article> pageInfo=articleService.list(start,end,select,pageNum);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("start", start);
		model.addAttribute("end",end);
		return "list";
	}
	
}
