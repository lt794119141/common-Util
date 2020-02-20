<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/css/index1.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
</head>
<body>
	<form action="list" method="get">
		<input type="date" name="start" value="start">-<input type="date" name="end" value="end" >  
		<select name="select" >
			<option value="">请选择</option>
			<option value="user_id">作者</option>
			<option value="commentCnt">评论数量</option>
			<option value="created">发布时间</option>
		</select>
		<input type="hidden" name="pageNum"  >
		<button>查询</button>
	</form>

	<table>
		<tr>
			<td>$</td>
			<td>标题</td>
			<td>作者</td>
			<td>发布时间</td>
			<td>评论数</td>
		</tr>
		<c:forEach items="${pageInfo.list }" var="art">
			<tr>
				<td>${art.id }</td>
				<td>${art.title }</td>
				<td>${art.user_name }</td>
				<td>${art.created }</td>
				<td>${art.commentCnt }</td>
			</tr>
		</c:forEach>
		<tr>
		<td colspan="5">
			<button onclick="fenye(${pageInfo.prePage==0?'1':pageInfo.prePage})">上一页</button>
			<button onclick="fenye(${pageInfo.nextPage==0?pageInfo.pages :pageInfo.nextPage})">下一页</button>
			当前${pageInfo.pageNum }/${pageInfo.pages }页，共${pageInfo.total }条数据
		</td>
</tr>
	</table>
	
	<script type="text/javascript">
		function fenye(pageNum) {
			$("[name=pageNum]").val(pageNum);
			$("form").submit();
		}
	</script>
</body>
</html>