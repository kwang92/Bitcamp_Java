package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerReader extends Thread{

	private DataInputStream in;
	private DataOutputStream out;
	private Socket socket;
	public ServerReader(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(this.socket.getInputStream());
			out = new DataOutputStream(this.socket.getOutputStream());
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
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
