package chatServer_UI;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender{
	private DataOutputStream out;
	private Socket socket;

	public Sender(Socket socket, String name) {

		this.socket = socket;
		try {
			out = new DataOutputStream(this.socket.getOutputStream());
			out.writeUTF(name);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendToServer(String msg) {
		try {
			out.writeUTF(msg);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
