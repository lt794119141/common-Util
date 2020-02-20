package com.litao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litao.dao.ArticleDao;
import com.litao.entity.Article;
import com.litao.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public PageInfo<Article> list(String start, String end, String select, Integer pageNum) {
		PageHelper.startPage(pageNum, 10);
		List<Article> list=articleDao.list(start,end,select);
		return new PageInfo<Article>(list) ;
	}

}
