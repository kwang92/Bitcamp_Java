package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.Member;

public class ImageServlet extends HttpServlet{
	private final String PATH = "C:\\user_pic\\";
	MemberDao dao = MemberDao.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ImageServlet");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Member mem = (Member)req.getSession().getAttribute("user");
		if(mem == null) {
			System.out.println("세션정보 없어");
		}
//		String id = mem.getMem_id();
		String fileName = mem.getProfile();             
		FileInputStream fis = new FileInputStream(new File(PATH+fileName));
		BufferedInputStream bis = new BufferedInputStream(fis);             
		resp.setContentType("image/png");
		BufferedOutputStream output = new BufferedOutputStream(resp.getOutputStream());
		for (int data; (data = bis.read()) > -1;) {
			System.out.println(data);
			output.write(data);
		}      
	}

}
