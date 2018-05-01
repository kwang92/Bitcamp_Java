package bank;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client_System{
	private static final String SERVER_IP = "192.168.0.26";
	private static final int PORT = 7000;
	private Customer tmp_Cus;
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public Client_System() {
		socket = new Socket();
		tmp_Cus = new Customer();
	}
	public Client_System(String account, String password) {	// 로그인 이용시 거쳐야하는 생성자
		try {
			socket = new Socket(SERVER_IP, PORT);	// 서버로 연결요청
			tmp_Cus = new Customer(account, password);
			out = new ObjectOutputStream(socket.getOutputStream());
			startClient();
			
		} catch (BindException e) { 
			System.out.println("바인드 Exception 발생");
		}
		catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	public void startClient() {	// 계좌번호, 해당 비밀번호가 정상적이면 해당 계좌 작업시작
		Receive recv = new Receive();
		recv.start();
		tmp_Cus.setDataType("REQ");
		sendCustomer();

	}
	public Customer getTmpCus() {
		return this.tmp_Cus;
	}
	public void setTmpCus(Customer cus) {
		this.tmp_Cus = cus;
	}
	public void sendCustomer() {
		
		try {
			out.writeObject(tmp_Cus);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public class Receive extends Thread{
		public void run() {
			try {
				in = new ObjectInputStream(socket.getInputStream());
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			while(true) {
				try {
					tmp_Cus = (Customer)in.readObject();
					System.out.println("연동완료");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}