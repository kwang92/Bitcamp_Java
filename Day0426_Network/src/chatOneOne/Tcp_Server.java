package chatOneOne;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcp_Server {
	private ServerSocket socket;
	private Socket clientSocket;
	private static final int PORT = 5555;
	private Sender sender;
	private Reader reader;

	public Tcp_Server() {
		try {
			socket = new ServerSocket(PORT);
			System.out.println("Socket Open");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean getConnect() {
		try {
			clientSocket = socket.accept();
			System.out.println("연결성공");

			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void startComm() {
		if (getConnect()) {
			System.out.println("데이터시작");
			sender = new Sender(clientSocket);
			reader = new Reader(clientSocket);
			sender.start();
			reader.start();
		}
	}
}

