package chatServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread{
	private DataOutputStream out;
	private Socket socket;
	public Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {	// 유저로부터 입력받은 내용을 서버로 전송
		try {
			Scanner user = new Scanner(System.in);
			String msg;
			while(true) {
				msg = user.next();
				out.writeUTF(msg+"\n");
				out.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
