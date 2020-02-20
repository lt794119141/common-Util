package com.litao.entity;

import java.io.Serializable;
import java.sql.Date;

public class Article implements Serializable {

	private Integer id;
	
	private String title;
	
	private Date created;
	
	private Integer user_id;
	
	private String user_name;
	
	private Integer commentCnt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(Integer commentCnt) {
		this.commentCnt = commentCnt;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", created=" + created + ", user_id=" + user_id
				+ ", user_name=" + user_name + ", commentCnt=" + commentCnt + "]";
	}

	public Article(Integer id, String title, Date created, Integer user_id, String user_name, Integer commentCnt) {
		super();
		this.id = id;
		this.title = title;
		this.created = created;
		this.user_id = user_id;
		this.user_name = user_name;
		this.commentCnt = commentCnt;
	}

	public Article() {
		super();
	}

	
	
	
}
