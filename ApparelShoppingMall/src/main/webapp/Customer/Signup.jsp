<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.dev.dao.CustomerDAO"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>

	<h3>회원가입</h3>

	<script type="text/javascript">
		function validation(obj) {

			if (!obj.id.value || obj.id.value.trim().length == 0) {
				alert("아이디를 입력하세요.");
				obj.id.value = "";
				obj.id.focus();
				return false;
			}

			if (!obj.pw.value || obj.pw.value.trim().length == 0) {
				alert("비밀번호를 입력하세요.");
				obj.pw.value = "";
				obj.pw.focus();
				return false;
			}

			if (!obj.name.value || obj.name.value.trim().length == 0) {
				alert("이름를 입력하세요.");
				obj.name.value = "";
				obj.name.focus();
				return false;
			}

			if (!obj.email.value || obj.email.value.trim().length == 0) {
				alert("이메일을 입력하세요.");
				obj.email.value = "";
				obj.email.focus();
				return false;
			}
		}
	</script>

	<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");

	if (CustomerDAO.idCheck(id)) {
		out.println("<script>");
		out.println("alert('아이디가 중복됩니다. 다른 아이디를 선택해주세요.)'");
		out.println("location.href='Signup.jsp'");
		out.println("</script>");
	}
	%>


	<form action='../CustomerInsert.do' method='post'
		onsubmit="return validation()">
		아이디 <input type='text' name='id' maxlength='20'><br> 비밀번호
		<input type='text' name='pw'><br> 이름 <input type='text'
			name='name'><br> 이메일 <input type='text' name='email'><br>
		<input type='button' value='회원가입' id='signup'>

	</form>

	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>

