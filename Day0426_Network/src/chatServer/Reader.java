package chatServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

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
	public void run() {
		
		while(true) {
			String msg;
			if(in != null) {
				try {
					msg = in.readUTF();
					System.out.println(msg);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
