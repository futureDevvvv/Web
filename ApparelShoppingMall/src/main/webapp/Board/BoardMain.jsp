<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>

	<jsp:include page="../menu.jsp"></jsp:include>

	<h1>자유게시판</h1>
	<form action="">
		<table border="1">
			<thead>
			<col width="50px">
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<tr>
				<th>No</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${requestScope.boardList }">
					<tr>
						<td>${item.b_id }</td>
						<td>${item.id }</td>
						<td>
						<a href="/BoardView.do?b_id=${item.b_id}">${item.b_title }</a>
						<td>${item.b_date }</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="Board/BoardWrite.jsp">글쓰기</a>
	</form>
</body>
</html>