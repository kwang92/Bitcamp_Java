import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	// ������ ���� : ��û�� �޾Ƽ� ó���ϴ� ��
	// HttpServlet�� ��û�� �޾Ƽ� ó���ϴ� �޼ҵ� : doGet, doPost



	@Override	// doGet�� source���� overide implement ����
	//	doGet �޼ҵ� : get����� ��û�� �޾Ƽ� ó��
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��û�޾Ƽ� ó���ϱ�  :  1. ���û�� �޾Ƽ� ó�� �� ���ΰ��� ���� ���� ( @WebServlet )
		// �ް����� req : ��û�� ���� ������ ��� �ִ� ��ü
		// �ް����� resp : ���信 ���� ������ ��� �ִ� ��ü
		
		PrintWriter pw = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		
		pw.print("<h1>Hello!!</h1>");
		pw.print("<br>");
		pw.print("<hr>");
	}

}