package tcp1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Tcp_Client {	// 프로그램 시작 시 Server에 연결, 연결이 되면 데이터 준비 및 전송
	private Socket socket;
	private static String IP = "192.168.0.26";
	private static int PORT = 5555;
	private DataInputStream in;
	private DataOutputStream out;
	
	public boolean setConnect() {
		try {
			socket = new Socket(IP,PORT);
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			return true;
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void startComm() {
		if(setConnect()) {
			Scanner user = new Scanner(System.in);
			String msg;
			String userMsg;
			while(true) {
				if(in != null) {
					try {
						System.out.print("메시지 입력 : ");
						userMsg = user.next();
						
						out.flush();
						out.writeUTF(userMsg);
						if(userMsg.equals("quit"))
							break;
						msg = in.readUTF();
					
						System.out.println(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
