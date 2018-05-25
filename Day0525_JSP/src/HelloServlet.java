import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	// 서블릿의 역할 : 요청을 받아서 처리하는 것
	// HttpServlet이 요청을 받아서 처리하는 메소드 : doGet, doPost



	@Override	// doGet을 source에서 overide implement 구현
	//	doGet 메소드 : get방식의 요청을 받아서 처리
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청받아서 처리하기  :  1. 어떤요청을 받아서 처리 할 것인가에 대한 설정 ( @WebServlet )
		// 메개변수 req : 요청에 대한 정보를 담고 있는 객체
		// 메개변수 resp : 응답에 대한 정보를 담고 있는 객체
		
		PrintWriter pw = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		
		pw.print("<h1>Hello!!</h1>");
		pw.print("<br>");
		pw.print("<hr>");
	}

}