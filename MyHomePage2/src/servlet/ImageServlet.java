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

import com.google.gson.Gson;

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
		
		String fileName = "";
		String cmd = "";
		if(req.getParameter("cmd") != null) {
			cmd = req.getParameter("cmd");
		}
		System.out.println("이미지 서블릿 cmd : "+cmd);
		Member mem = null;
		if(cmd.equals("other")) {
			mem = dao.selectOne(req.getParameter("who"));
			
		} else if(cmd.equals("home")) {
			fileName = "home2.jpg";
		} else if(cmd.equals("mainLogo")) {
			fileName = "mainLogo.png";
			
		} else {
			mem = (Member)req.getSession().getAttribute("user");
		}
		
		if(mem != null) {	// 로고 관련 이미지 처리
			fileName = mem.getProfile();
		}
		

		FileInputStream fis = new FileInputStream(new File(PATH+fileName));
		BufferedInputStream bis = new BufferedInputStream(fis);             
		resp.setContentType("image/jpg");
		BufferedOutputStream output = new BufferedOutputStream(resp.getOutputStream());
		
		for (int data; (data = bis.read()) > -1;) {
			output.write(data);
		}
		output.flush();
		output.close();
		fis.close();
	}

}
