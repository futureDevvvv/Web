<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="com.dev.vo.CustomerVO" %>
<%
CustomerVO vo = (CustomerVO) request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<jsp:include page="../menu.jsp"></jsp:include>

	<%
	//세션에 id 값이 담겨 있는지 체크
	String id = null;
	if (session.getAttribute("id") != null) {
		id = (String) session.getAttribute("id");
	}

	//로그인 하지 않았을 때 로그인 경고창 띄워줌
	if (id == null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('먼저 로그인하세요.')");
		response.sendRedirect("login.jsp");
		script.println("</script>");
		//게시글 작성 폼
	} else {
	%>
	<h3>마이페이지</h3>

	<form method="post" action="../CustomerUpdate.do">
	<input type="hidden" name="id" value="<%=vo.getId() %>" />
		 비밀번호 <input type='text' name='pw' value="<%=vo.getPw() %>"><br> 
		 이름 <input type='text' name='name' value="<%=vo.getName() %>"><br>
		 이메일 <input type='text' name='email' value="<%=vo.getEmail() %>"><br>
		
		<input type='reset' value='다시 입력'>
		<input type='button' value='수정' id='customerUpdate'>
	</form>

	<%
	}
	%>

</body>
</html>