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
	@Override	// ���Ͼ��ε�� Post��ĸ� ����
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");	
		// ��û�� ������
		// 1. ����ε� ��û���� Ȯ��, ������ Ÿ�� �����ͼ� Ȯ��
		// 2. �����̸��� DB�� ����
		// 3.
		String contentType = req.getContentType();
		
		if(contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
			// ���Ͽ�û
			saveFileName(req, resp);
		}
		
		
	}
	private void saveFileName(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// �����̸��� �ߺ��Ǵ� ��� �����ͺ��̽��� ������� �ʰų� 
		// �������� ������ ������ �� ������ �߻� �� �� �ִ�.
		// �׷��� ���ε�Ǵ� �����̸��� UUID�� �̿��Ѵ�.
		
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
