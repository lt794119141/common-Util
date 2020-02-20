package com.litao.service;

import com.github.pagehelper.PageInfo;
import com.litao.entity.Article;

public interface ArticleService {

	PageInfo<Article> list(String start, String end, String select, Integer pageNum);

}
