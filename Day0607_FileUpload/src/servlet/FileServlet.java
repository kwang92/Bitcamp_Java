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
		
		// ?command=fileList  (파일리스트 보여주기) ?command=download  (파일 다운로드)  
		String command = req.getParameter("command");
		
		if(command != null) {
			if(command.equals("fileList")) {
				// Service에서 파일목록 가져오기
				List<String> fList = service.getFileList();
				req.setAttribute("fileList", fList);
				req.getRequestDispatcher("fileList.jsp").forward(req, resp);
			}
			else if(command.equals("download")) {
				// Service에서 파일 가져오기
				String fName = req.getParameter("filename");
				String path = "C:\\tmp\\";
				String filePath = path+fName;	// default 경로에 파일이 있으면 파일이름만 경로가 필요하면 해당 폴더의 경로 + 파일이름
				
				// 경로를 통해 파일을 복사해온다.
				byte[] b = new byte[4096];
				FileInputStream fis = new FileInputStream(filePath);
				
				// 파일을 응답에 실어서 전달 할 때 파일의 종류를 헤더정보에 담아서 전달해야한다.
				// 파일의 종류 및 실행 어플리케이션에 대한 정의
				String sMimeType = getServletContext().getMimeType(filePath);
				if(sMimeType == null) {
					sMimeType = "application/octect-stream";
				}
				resp.setContentType(sMimeType);
				
				///////   UUID 지워서 다운받기   ////////////
				int index = fName.indexOf("_");
				String originFileName = fName.substring(index+1);
				///////////////////////////////////////
				String strEncoding = new String(fName.getBytes("utf-8"),"8859_1");
				resp.setHeader("Content-Disposition", "attachment;filename="+strEncoding);
				
				// MIME TYPE 설정 완료를 하면 파일을 보내면 된다.
				ServletOutputStream servletOutputStream = resp.getOutputStream();
				
				int readNum = 0;
				while( ( readNum = fis.read(b,0,b.length) ) != -1) {
					servletOutputStream.write(b,0,readNum);	// byte배열의 0번부터 readNum길이 만큼의 데이터를 outputstream에 write한다.
				}
				servletOutputStream.flush();
				servletOutputStream.close();
				fis.close();
			}
		}
	}
}
