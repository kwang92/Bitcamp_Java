package guiChat3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerManager {
	private List<Socket> socketList;
	
	public ServerManager() {
		socketList = new ArrayList<Socket>();
	}
	
	public void add(Socket socket) {
		socketList.add(socket);
		new ServerThread(socket).start();
		
	}

	class ServerThread extends Thread{
		private String nick = "이름없음";
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
//			BufferedReader reader = null;
			ObjectInputStream in = null;
			ObjectOutputStream out = null;
			try {
				in = new ObjectInputStream(socket.getInputStream());
				
				//소켓으로 부터 메시지를 읽어오는 부분
				while(true) {
					Protocol p;
					try {
						p = (Protocol)in.readObject();
						if(p.getType().equals("#02")) {
							for(int i = 0; i < socketList.size(); i++) {
								out = new ObjectOutputStream(socketList.get(i).getOutputStream());
								out.writeObject(p);
							}
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}
	
}
