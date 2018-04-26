package tcp1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcp_Server {
	private ServerSocket socket;
	private Socket clientSocket;
	private static final int PORT = 5555;
	private DataInputStream in;
	private DataOutputStream out;

	public Tcp_Server() {
		try {
			socket = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean getConnect() {
		try {
			clientSocket = socket.accept();
			System.out.println("연결성공");
			out = new DataOutputStream(clientSocket.getOutputStream());
			in = new DataInputStream(clientSocket.getInputStream());

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
			String msg;
			while (true) {
				try {
					msg = in.readUTF();
					if (msg.equals("quit")) {
						break;
					}
					out.writeUTF("echo : " + msg + "\n");
					out.flush();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

