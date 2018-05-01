package bank;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	//얘가 할일은 소켓 연결 받기 : 계속..반복하면서
	public static void main(String[] args) {
		ServerSocket serverSocket;
		ServerManager manager = new ServerManager();
		try {
			
			serverSocket = new ServerSocket(7000);
			while(true) {
				System.out.println("요청 대기중...");
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트 연결 되었습니다.");
				//서버 매니져에게 소켓 넘겨주기
				manager.add(socket);
			}
		} catch(BindException e) { 
			System.out.println("Bind Exception 발생");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
