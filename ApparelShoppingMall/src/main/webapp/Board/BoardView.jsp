<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="com.dev.dao.BoardDAO"%>
<%@ page import="com.dev.vo.BoardVO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//아이디 세션 존재 여부 체크
	String id = null;
	if (session.getAttribute("id") != null) {
		id = (String) session.getAttribute("id");
	}
	%>


	<%
	int b_id = 0;

	//글 번호가 존재한다면 변수에 담음
	if (request.getParameter("b_id") != null) {
		b_id = Integer.parseInt(request.getParameter("b_id"));
		
		System.out.println(b_id);
	}


	//글 번호가 존재하지 않으면 경고창 띄움.
	if (b_id == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('유효하지 않은 글입니다.')");
		script.println("location.href=BoardMain.do");
		script.println("</script>");
	}

	//유효한 글이면 구체적인 정보 담음
	BoardVO vo = new BoardDAO().selectOne(b_id);
	%>

	<%
	/*BoardVO vo = (BoardVO) request.getAttribute("board");*/
	%>

	<!-- 글 보기 양식 -->
	<div class="container">
		<div class="row">
			<table class="boardTable" style="border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2">게시판 글 보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>글 번호</td>
						<td><%=vo.getB_id()%></td>
					</tr>


					<tr>
						<td style="width: 20%;">글 제목</td>
						<td colspan="2"><%=vo.getB_title()%></td>
					</tr>

					<tr>
						<td>작성자</td>
						<td colspan="2"><%=vo.getId()%></td>
					</tr>

					<tr>
						<td>작성일자</td>
						<td colspan="2"><%=vo.getB_date()%></td>
					</tr>

					<tr>
						<td>내용</td>
						<td colspan="2" style="height: 200px; text-align: Left;"><%=vo.getB_content()%></td>
					</tr>

				</tbody>
			</table>

			<a href="BoardMain.do">글 목록</a>

			<!-- 본인이 쓴 글은 수정과 삭제 버튼 생성 -->
			<%
			if (id != null && id.equals(vo.getId())) {
			%>


			<%
			}
			%>




		</div>

	</div>



</body>
</html>