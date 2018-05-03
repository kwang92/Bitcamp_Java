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
	private Customer tmp_Cus;		// Client System에서 Server로부터 객체를 받아서 사용할 임시 객체
	private TransAction tran;		// 서버로 요청할 작업을 저장할 트랜잭션 객체
	private Socket socket;			// 서버와 연결될 클라이언트 소켓
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public Client_System() {
		socket = new Socket();		
		tmp_Cus = new Customer();	
		tran = new TransAction();	
	}
	public Client_System(String name,String account, String password) {	// 로그인 이용시 거쳐야하는 생성자
		try {
			socket = new Socket(SERVER_IP, PORT);	// 서버로 연결요청
			tmp_Cus = new Customer(name, account, password);
			tran = new TransAction();
			out = new ObjectOutputStream(socket.getOutputStream());
			startClient();	// 새로운 client 생성 후 최초작업 실행
		} 
		catch (BindException e) {}
		catch (UnknownHostException e) {} 
		catch (IOException e) {}
	}
	public void startClient() {	// 서버로 NW 트랜잭션 명령을 보내 새로운 Customer를 서버가 등록하게 요청
		Receive recv = new Receive();
		recv.start();
		tran.setJob("NW");
		tran.setMsg(tmp_Cus.getName()+","+tmp_Cus.getAccount().getAccountNum()+","+tmp_Cus.getAccount().getPassword());
		sendCustomer();

	}
	public void sendCustomer() {	// 상황에 맞는 명령을 서버에 요청하는 메소드
		try {
			out.writeObject(tran);
			out.flush();
			out.reset();
		} catch (IOException e1) {}
	}
	public TransAction getTransAction() {
		return this.tran;
	}
	public Customer getTmpCus() {
		return this.tmp_Cus;
	}
	public void setTmpCus(Customer cus) {
		this.tmp_Cus = cus;
	}
	public class Receive extends Thread{	// 서버로부터 계속해서 정보를 갱신받기 위한 receive 쓰레드
		public void run() {
			try {
				in = new ObjectInputStream(socket.getInputStream());			
			} 
			catch (IOException e1) {}
			
			while(true) {
				try {
					tmp_Cus = (Customer)in.readObject();
				} 
				catch (ClassNotFoundException e) {} 
				catch (IOException e) {}
			}
		}
	}

}