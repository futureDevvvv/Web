package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.parser.Cookie;

/**
 * Servlet implementation class GetCookieValue
 */
@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		javax.servlet.http.Cookie[] allValues = request.getCookies(); //getCookie -> 브라우저에 쿠키 정보 요청, 이후 쿠키 정보를 배열로 가져옴.
		for (int i = 0; i < allValues.length; i++) {
			if (allValues[i].getName().equals("cookieTest")) {
				out.println("<h2>Cookie : " + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
			}
		}

	}

}
