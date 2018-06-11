package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FileService;

@WebServlet("/file")
public class FileServlet extends HttpServlet{
	private FileService service;
	
	public FileServlet() {
		service = FileService.getInstance();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}
	
	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// ?command=fileList  (���ϸ���Ʈ �����ֱ�) ?command=download  (���� �ٿ�ε�)  
		String command = req.getParameter("command");
		
		if(command != null) {
			if(command.equals("fileList")) {
				// Service���� ���ϸ�� ��������
				List<String> fList = service.getFileList();
				req.setAttribute("fileList", fList);
				req.getRequestDispatcher("fileList.jsp").forward(req, resp);
			}
			else if(command.equals("download")) {
				// Service���� ���� ��������
				String fName = req.getParameter("filename");
				String path = "C:\\tmp\\";
				String filePath = path+fName;	// default ��ο� ������ ������ �����̸��� ��ΰ� �ʿ��ϸ� �ش� ������ ��� + �����̸�
				
				// ��θ� ���� ������ �����ؿ´�.
				byte[] b = new byte[4096];
				FileInputStream fis = new FileInputStream(filePath);
				
				// ������ ���信 �Ǿ ���� �� �� ������ ������ ��������� ��Ƽ� �����ؾ��Ѵ�.
				// ������ ���� �� ���� ���ø����̼ǿ� ���� ����
				String sMimeType = getServletContext().getMimeType(filePath);
				if(sMimeType == null) {
					sMimeType = "application/octect-stream";
				}
				resp.setContentType(sMimeType);
				
				///////   UUID ������ �ٿ�ޱ�   ////////////
				int index = fName.indexOf("_");
				String originFileName = fName.substring(index+1);
				///////////////////////////////////////
				String strEncoding = new String(fName.getBytes("utf-8"),"8859_1");
				resp.setHeader("Content-Disposition", "attachment;filename="+strEncoding);
				
				// MIME TYPE ���� �ϷḦ �ϸ� ������ ������ �ȴ�.
				ServletOutputStream servletOutputStream = resp.getOutputStream();
				
				int readNum = 0;
				while( ( readNum = fis.read(b,0,b.length) ) != -1) {
					servletOutputStream.write(b,0,readNum);	// byte�迭�� 0������ readNum���� ��ŭ�� �����͸� outputstream�� write�Ѵ�.
				}
				servletOutputStream.flush();
				servletOutputStream.close();
				fis.close();
			}
		}
	}
}
