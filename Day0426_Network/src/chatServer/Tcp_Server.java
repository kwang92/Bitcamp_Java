package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class Tcp_Server extends Thread{
	private ServerSocket socket;
	private Socket clientSocket;

	private static final int PORT = 5000;
	private ArrayList<ServerReader> reader;
	private ArrayList<Socket> client_List;
	public Tcp_Server() {
		try {
			socket = new ServerSocket(PORT);
			reader = new ArrayList<ServerReader>();
			client_List = new ArrayList<Socket>();
			System.out.println("Socket Open");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {	
		try {	// 리스트에 1명만 들어 왔따 list(0) size = 1-1 
			while(true) {
				clientSocket = socket.accept();
				client_List.add(clientSocket);	// 들어온 소켓List 저장
				reader.add(new ServerReader(clientSocket));	// 각 소켓당 reader 쓰레드 생성
				reader.get(reader.size()-1).start();	// 각 소켓의 reader 쓰레드 시작
				System.out.println("Client 추가");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public class ServerReader extends Thread{	// innerClass ServerReader
		private DataInputStream in;
		private DataOutputStream out;
		private Socket socket;
		public ServerReader(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(this.socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void run() {
			while(true) {
				String msg;
				if(in != null) {
					try {
						msg = in.readUTF();
						sendToAll(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		public void sendToAll(String msg) {
			for(int i = 0; i < client_List.size(); i++) {
				try {
					out = new DataOutputStream(client_List.get(i).getOutputStream());
					msg = client_List.get(i).getInetAddress().getHostAddress()+": "+msg;
					out.writeUTF(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}