package chatServer_UI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Tcp_Server extends Thread{
	private ServerSocket socket;
	private Socket clientSocket;
	private static int total_Client = 0;
	
	private static final int PORT = 5000;
	private ArrayList<ServerReader> reader;
	private ArrayList<Socket> client_List;
	private String[] client_Name;
	public Tcp_Server() {
		this.client_Name = new String[0];
		try {
			socket = new ServerSocket(PORT);		// ServerSocket Port를 지정해서 열어준다.
			reader = new ArrayList<ServerReader>();	// 접속한 소켓들에 1:1대응하는 reader클래스의 ArrayList
			client_List = new ArrayList<Socket>();	// 접속한 소켓들을 저장할 ArrayList
			System.out.println("Socket Open");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUsers(int index) {
		return client_Name[index];
	}
	public void setUserName(String name) {
		String[] tmp = client_Name;
		client_Name = new String[total_Client+1];
		for(int i = 0; i < tmp.length; i++) {
			client_Name[i] = tmp[i];
		}
		this.client_Name[total_Client] = name;
		total_Client++;
	}
	public void run() {	
		try {
			while(true) {
				clientSocket = socket.accept();	// 새로운 소켓 연결이 들어올때 까지 accept() 대기
				client_List.add(clientSocket);	// 새로 들어온 소켓을 ArrayList에 저장
				reader.add(new ServerReader(clientSocket));	// reader클래스에 새로 들어온 소켓을 넣어서 ArrayList에 추가
				reader.get(reader.size()-1).start();	// 새로 생성된 ArrayList의 reader 쓰레드 start
				System.out.println("Client 추가");
			}	
		} catch (SocketException e) { 
			System.out.println("소켓 생성 실패");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException 발생");
		}
	}
	

	public class ServerReader extends Thread{	// innerClass ServerReader
		private DataInputStream in;
		private DataOutputStream out;
		private Socket socket;
		public ServerReader(Socket socket) {
			this.socket = socket;	// 연결들어온 소켓을 넣어준다.
			try {
				in = new DataInputStream(this.socket.getInputStream()); // 소켓으로 부터 입력을 받아들일 InputStream
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void run() {
			try {
				setUserName(in.readUTF());	// 사용자의 이름을 설정한다.
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(true) {
				String msg;
				if(in != null) {	// in에 객체가 생성됬는지 확인
					try {
						msg = in.readUTF();	// Input이 들어올때 까지 대기
						sendToAll(msg);		// Input이 들어올 시 접속해있는 모든 소켓들에게 msg전달
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		public void sendToAll(String msg) {
			for(int i = 0; i < client_List.size(); i++) {	// 소켓 ArrayList에 있는 모든 사용자들에게 메시지 전송
				try {
					if(this.socket.equals(client_List.get(i)))
						continue;
					out = new DataOutputStream(client_List.get(i).getOutputStream());
					msg = getUsers(i)+" : "+msg;	// 메시지를 보내는 객체의 ip + msg내용전송
					System.out.println("전송");
					out.writeUTF(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}