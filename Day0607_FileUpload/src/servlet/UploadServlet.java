package servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.FileService;


public class UploadServlet extends HttpServlet{
	private FileService service;
	
	public UploadServlet() {
		service = FileService.getInstance();
	}
	@Override	// 파일업로드는 Post방식만 가능
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");	
		// 요청이 들어오면
		// 1. 제대로된 요청인지 확인, 컨텐츠 타입 가져와서 확인
		// 2. 파일이름을 DB에 저장
		// 3.
		String contentType = req.getContentType();
		
		if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			// 파일요청
			saveFileName(req, resp);
		}
		
		
	}
	private void saveFileName(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 파일이름이 중복되는 경우 데이터베이스에 저장되지 않거나 
		// 서버에서 파일을 관리할 때 문제가 발생 할 수 있다.
		// 그래서 업로드되는 파일이름을 UUID를 이용한다.
		
		Collection<Part> parts = req.getParts();
		for(Part part : parts) {
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				String fileName = part.getSubmittedFileName();
				UUID uuid = UUID.randomUUID();
				String saveName = uuid.toString()+"_"+fileName;
				if(part.getSize() > 0) {
					//part.write("C:\\tmp\\"+fileName);
					part.write(saveName);
					service.uploadFile(saveName);
				}
			}
		}
	}

}
