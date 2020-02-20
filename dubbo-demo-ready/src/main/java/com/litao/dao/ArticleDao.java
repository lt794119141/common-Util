package com.litao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.litao.entity.Article;

public interface ArticleDao {

	List<Article> list(@Param("start")String start, @Param("end")String end, @Param("select")String select);

}
