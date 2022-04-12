<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
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
		script.println("alert('글쓰기 권한이 없습니다. 먼저 로그인하세요.')");
		response.sendRedirect("login.jsp");
		script.println("</script>");
	//게시글 작성 폼
	} else {
	%>
	<div class="container">
		<div class="row">
			<form method="post" action="../BoardInsert.do">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<tbody>
						<tr>
							<td><input type="text" class="form-control"
								placeholder="제목을 입력하세요" name="title" maxlengh="300"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="본문을 입력하세요"
									name="content" maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<!-- 글쓰기 버튼 생성-->
				<input type="submit" class="submitBtn" value="입력">
			</form>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>