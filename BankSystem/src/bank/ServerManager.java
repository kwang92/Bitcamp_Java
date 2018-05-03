package bank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ServerManager{
	private List<Customer> cus_List;
	private List<Socket> socketList;

	public ServerManager() {
		socketList = new ArrayList<Socket>();	// 들어온 소켓들을 관리하는 ArrayList
		cus_List = new ArrayList<Customer>();	// 들어온 Customer들을 관리하는 ArrayList
	}

	public void add(Socket socket) {
		socketList.add(socket);
		ServerThread st = new ServerThread(socket);
		st.start();
	}

	class ServerThread extends Thread{	// Server에 들어오는 customer 마다 실행시킬 Thread
		private Socket socket;
		private int manage_Index;
		private Customer current;
		private BufferedWriter bw;
		private PrintWriter pw;
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
				while(true) {	// DE, WD, TR, SH
					TransAction tmp = (TransAction)in.readObject();	// 실행할 작업종류, 금액등 정보를 가지고있는 객체
					String job = tmp.getJob();						// 실행할 작업을 따로 저장
					
				
					if(job.equals("NW")) {	// NW, NeW 작업을 받았을 때 처리하는 기능 (신규생성)
						String[] info = tmp.getMsg().split(",");
						cus_List.add(new Customer(info[0],info[1],info[2]));
						manage_Index = cus_List.size()-1;
						continue;
					}
					
					current = cus_List.get(manage_Index);			// 현재 다룰 Customer객체를 저장
					String path = current.getAccount().getAccountNum()+".txt";			// 계좌번호로 거래내역을 저장해서 계속 사용
					bw = new BufferedWriter(new FileWriter(path,true));	// 이행한 작업내용을 기록한 파일 writer
					pw = new PrintWriter(bw,true);
					
					Calendar cal = Calendar.getInstance();	// 작업이행 날짜를 저장할 Calendar 객체
					String date_Today = cal.get(cal.YEAR)+"."+(cal.get(cal.MONTH)+1)+"."+cal.get(cal.DATE);
					
					// DE 명령을 받았을 때는, current(현재 관리하는 customer)의 잔고에서 요청한 money만큼 deposit을 해주고 customer전송
					if(job.equals("DE")) {	// DE, Deposit 작업을 받았을 때 처리하는 기능
						current.getAccount().deposit(tmp.getMoney());
						out.writeObject(current);
						System.out.println("입금완료");
						
						bw.write(date_Today+" = ");
						bw.write(tmp.getMoney()+"원 입금");
						bw.newLine();
					}
					
					// WD 명령을 받았을 때는, current의 잔고에서 요청한 money만큼 withdraw 해주고 customer에 전송
					else if(job.equals("WD")) {	// WD, WithDraw 작업을 받았을 때 처리하는 기능
						current.getAccount().withdraw(tmp.getMoney());
						out.writeObject(current);
						System.out.println("출금완료");
						bw.write(date_Today+" = ");
						bw.write(tmp.getMoney()+"원 출금");
						bw.newLine();
					}
					
					// REQ 명령을 받았을 때는, 현재 관리하고 있는 최신 current객체 전송
					else if(job.equals("REQ")) { // REQ, REQuest 작업을 받았을 때 처리하는 기능
						out.writeObject(current);
						System.out.println(current.getAccount().getBal());
					}
					
					// TR 명령을 받았을 때는, current에서 money만큼 widthdraw 해주고 target객체를 list에서 찾아 money만큼 deposit해준다.
					else if(job.equals("TR")) {	// TR, TRansmission 작업을 받았을 때 처리하는 기능	
						current.getAccount().withdraw(tmp.getMoney());
						for(int i = 0; i < cus_List.size(); i++) {
							if(cus_List.get(i).getAccount().getAccountNum().equals(tmp.getTarget())) {
								cus_List.get(i).getAccount().deposit(tmp.getMoney());
								bw.write(date_Today+" = ");
								bw.write("\""+cus_List.get(i).getName()+"\"님에게 "+tmp.getMoney()+"원 송금");
								bw.newLine();
								break;
							}
						}
					}
					out.flush();
					out.reset();
					pw.flush();
					pw.close();			
				}
			} 
			catch (SocketException e) {} 
			catch (IOException e) {} 
			catch (ClassNotFoundException e) {} 
		}
	}
}