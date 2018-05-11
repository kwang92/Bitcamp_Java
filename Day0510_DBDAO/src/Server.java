import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	private ServerManager manager;
	private static final int PORT = 5000;
	public Server() {
		try {
			serverSocket = new ServerSocket(PORT);
			manager = new ServerManager();
			while(true) {
				Socket socket = serverSocket.accept();
				manager.addSocket(socket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public class ServerManager{
		private Socket socket;
		
		public void addSocket(Socket socket) {
			this.socket = socket;
			new ServerThread().start();
		}
		
		class ServerThread extends Thread{
			public void run() {
				
			}
		}
	}
}
