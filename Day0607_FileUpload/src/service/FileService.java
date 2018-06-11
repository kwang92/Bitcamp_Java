package service;

import java.util.List;

import dao.FileDao;

public class FileService {
	private static FileDao fileDao;
	private static FileService service;
	private FileService() {
		fileDao = FileDao.getInstance();
	}
	public static FileService getInstance() {
		if(service == null) {
			service = new FileService();
			
		}
		
		return service;
	}
	public boolean uploadFile(String fileName) {
		boolean result = fileDao.insertFile(fileName);
		
		return result;
	}
	public List<String> getFileList(){
		return fileDao.selectAll();
	}
}
