package guiChat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender{
//	private DataOutputStream out;
	private ObjectOutputStream out;
	private Socket socket;

	public Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendToServer(String msg) {
		try {
//			out.writeUTF(msg);
//			out.flush();
			
			out.writeObject(msg);
			out.flush();
			out.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
