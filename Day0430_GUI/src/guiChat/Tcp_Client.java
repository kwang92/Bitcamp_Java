package guiChat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
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
		this.setIP();
	}
	public boolean setConnect() {	// 서버와 소켓 연결, 연결 성공 시 true 반환, 실패 시 false 반환
		try {
			socket = new Socket(IP,PORT);

			return true;

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("IP주소나 PORT번호가 잘못되었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception 발생");
		}
		return false;
	}
	public void startComm() {	// 채팅기능 시작
		if(setConnect()) {	// startComm에서 setConnect 호출 ( 서버와의 연결 )
			// 서버와의 연결 성공 시 sender, reader 쓰레드 start
			System.out.println("연결성공");
			sender = new Sender(socket);
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
	public void setIP() {	// IP를 아무것도 입력하지 않을 시 default ip로 192.168.0.26 지정
		if( ( this.IP = getIP() ) == null){
			this.IP = "192.168.0.26";
		}
		System.out.println("연결 IP " + this.IP);
	}
	public void addChat(String msg) {
		super.setTa(msg);
	}
	public class Reader extends Thread{
		private ObjectInputStream in;
		//	private DataInputStream in;
		private Socket socket;
		public Reader(Socket socket) {
			this.socket = socket;
			try {
				//		in = new DataInputStream(this.socket.getInputStream());
				in = new ObjectInputStream(this.socket.getInputStream());
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
						//	msg = in.readUTF();
						msg = (String)in.readObject();
						addChat(msg);

					} catch (SocketException e) {
						System.out.println(IP+" User out");
						break;
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}
}