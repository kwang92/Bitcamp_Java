package chatServer_UI;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Tcp_Client extends ChatFrame {	// 프로그램 시작 시 Server에 연결, 연결이 되면 데이터 준비 및 전송
	private Socket socket;
	private static String IP = "192.168.0.26";	// 연결요청 할 서버의 IP
	private static int PORT = 5000;				// 연결요청 할 지정 Port
	private Sender sender;
	private Reader reader;
	private String name;

	
	public Tcp_Client() {
		Scanner input = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		name = input.next();
	}
	public boolean setConnect() {	// 서버와 소켓 연결, 연결 성공 시 true 반환, 실패 시 false 반환
		try {
			socket = new Socket(IP,PORT);

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
	public void startComm() {	// 채팅기능 시작
		if(setConnect()) {	// startComm에서 setConnect 호출 ( 서버와의 연결 )
			// 서버와의 연결 성공 시 sender, reader 쓰레드 start
			sender = new Sender(socket, name);
			super.setSender(sender);
			reader = new Reader(socket);
			reader.start();
		} else {
			System.out.println("서버와의 연결실패");
		}
	}
	public Sender getSender() {
		return this.sender;
	}
	
	public void addChat(String msg) {
		super.setTa(msg);
	}
	public class Reader extends Thread{

		private DataInputStream in;
		private Socket socket;
		public Reader(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(this.socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void run() {	// 서버로부터 들어오는 input 내용을 받는 쓰레드
			while(true) {	
				String msg;
				if(in != null) {
					try {
						msg = in.readUTF();
						addChat(msg);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
