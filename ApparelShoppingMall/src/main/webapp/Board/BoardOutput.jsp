<%@page import="com.dev.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file='../menu.jsp' %>

<%
	String id = (String) session.getAttribute("id");
	if(id == null){
		response.sendRedirect("login.jsp");
	} else {
%>

	<%
	/* Integer.parseInt(""); */
	BoardVO vo = (BoardVO) request.getAttribute("board");
	%>
	<div class="container">
		<div class="row">
			<table class="boardTable" style="border: 1px solid #dddddd">
				<tbody>
					<tr>
						<td style="width: 20%;">글 제목</td>
						<td colspan="2"><%=vo.getB_title()%></td>
					</tr>

					<tr>
						<td>작성자</td>
						<td colspan="2"><%=vo.getId()%></td>
					</tr>

					<tr>
						<td>내용</td>
						<td colspan="2" style="height: 200px; text-align: Left;"><%=vo.getB_content()%></td>
					</tr>
				</tbody>
			</table>
	
	<a href="BoardMain.do">글 목록</a>
	
	<% 
	}
%>
	
	<%@ include file="../footer.jsp" %>
</body>
</html>

</body>
</html>