package bank;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ServerManager {
	private List<Customer> cus_List;
	private List<Socket> socketList;
	/*
	private static final String path = "C:\\Users\\bit\\Desktop\\ryu\\javaProject\\BankSystem\\src\\record.txt";
	private File inFile;
	private File outFile;
	*/
	public ServerManager() {
		socketList = new ArrayList<Socket>();
		cus_List = new ArrayList<Customer>();
		cus_List.add(new Customer("1010","1234"));
		cus_List.get(0).getAccount().deposit(20000);	// 1010계좌는 2만원을 가지고 시작
		
		cus_List.add(new Customer("2020","1234"));
		cus_List.get(1).getAccount().deposit(10000);	// 2020계좌는 만원을 가지고 시작
	}

	public void add(Socket socket) {
		socketList.add(socket);
		ServerThread st = new ServerThread(socket);
		st.start();

	}

	class ServerThread extends Thread{
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			ObjectInputStream in = null;
			ObjectOutputStream out = null;
			try {
				in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
				//소켓으로 부터 메시지를 읽어오는 부분
				while(true) {
					Customer tmp = (Customer)in.readObject();
					if(tmp.getDataType().equals("COMMIT")) {
						System.out.println("commit할 계좌 찾는중");
						int i;
						for(i = 0; i < cus_List.size(); i++) {
							if(tmp.getAccount().getAccount().equals(cus_List.get(i).getAccount().getAccount())) {
								cus_List.remove(i);
								System.out.println("저장한 계좌: "+tmp.getAccount().getAccount());
								break;
							}
						}
						cus_List.add(tmp);
						Socket tmpSock = socketList.get(i);
						out = new ObjectOutputStream(tmpSock.getOutputStream());
						out.writeObject(tmp);
						System.out.println("commit완료");
					}else if(tmp.getDataType().equals("SHOW")) {
						// 일단 나중에 구현
						
					}else if(tmp.getDataType().equals("REQ")) {
						for(int i = 0; i < cus_List.size(); i++) {
							if(tmp.getAccount().getAccount().equals(cus_List.get(i).getAccount().getAccount())) {
								out.writeObject(cus_List.get(i));
								break;
							}	// 해당 계좌에 해당하는 객체정보를 보내줘서 client_system의 tmp_Cus에 넣어줌
						}
					}
				}

			} catch (SocketException e) { 
				System.out.println("소켓 exception 발생");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

		}
	}

}
