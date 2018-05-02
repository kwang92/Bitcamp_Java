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
		socketList = new ArrayList<Socket>();
		cus_List = new ArrayList<Customer>();
	}

	public void add(Socket socket) {
		socketList.add(socket);
		ServerThread st = new ServerThread(socket);
		st.start();
	}


	class ServerThread extends Thread{
		
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
					TransAction tmp = (TransAction)in.readObject();
					String job = tmp.getJob();
					
					System.out.println("들어온 Transaction "+job);
					
					if(job.equals("NW")) {	// 등록되지 않는 새로운 고객이 들어오면 이렇게 해줌
						String[] info = tmp.getMsg().split(",");
						cus_List.add(new Customer(info[0],info[1],info[2]));
						manage_Index = cus_List.size()-1;
						continue;
					}
					
					current = cus_List.get(manage_Index);
					String path = "C:\\Users\\bit\\Desktop\\ryu\\store\\BankSystem\\src\\record"+current.getName()+".txt";
					bw = new BufferedWriter(new FileWriter(path,true));
					pw = new PrintWriter(bw,true);
					Calendar cal = Calendar.getInstance();
					
					if(job.equals("DE")) {
						current.getAccount().deposit(tmp.getMoney());
						System.out.println(current.getAccount().getBal());
						out.writeObject(current);
						System.out.println("입금완료");
						
						bw.write(cal.get(cal.YEAR)+"."+(cal.get(cal.MONTH)+1)+"."+cal.get(cal.DATE)+" = ");
						bw.write(tmp.getMoney()+"원 입금");
						bw.newLine();
					}else if(job.equals("WD")) {
						current.getAccount().withdraw(tmp.getMoney());
						out.writeObject(current);
						System.out.println("출금완료");
						bw.write(cal.get(cal.YEAR)+"."+(cal.get(cal.MONTH)+1)+"."+cal.get(cal.DATE)+" = ");
						bw.write(tmp.getMoney()+"원 출금");
						bw.newLine();
					}else if(job.equals("REQ")) {
						out.writeObject(current);
						System.out.println(current.getAccount().getBal());
					}else if(job.equals("TR")) {	
						current.getAccount().withdraw(tmp.getMoney());
						for(int i = 0; i < cus_List.size(); i++) {
							if(cus_List.get(i).getAccount().getAccount().equals(tmp.getTarget())) {
								System.out.println("target을 찾았다");
								cus_List.get(i).getAccount().deposit(tmp.getMoney());
								break;
							}
						}
					}
					out.flush();
					out.reset();
					pw.flush();
					pw.close();
					
					
					
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
