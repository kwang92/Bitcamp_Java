package multiChatting;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChatServer implements Runnable{
	private static final int PORT = 5000;
	private DatagramSocket socket;
	private Set<String> set;
	private Sender send;
	public ChatServer() {
		set = new HashSet<String>();
	}
	public void run() {
		try {
			socket = new DatagramSocket(PORT);	// 서버 소켓을 5000PORT 로 열어준다.
			
			while(true) {
				System.out.println("데이터 수신 대기중...");
				byte[] buf = new byte[512];	// 한번에 받아올 최대 data 사이즈를 512로 정한다.
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);	// data를 받을 때 까지 대기한다.
				String ip = packet.getAddress().getHostAddress();	// 들어온 packet의 ip를 저장한다.
				set.add(ip);	// set에 중복없이 연결되있는 IP들을 저장한다.
				
				String ip2 = ip;	// 현재 메시지 들어온 ip
				
				Iterator<String> it = set.iterator();	// set의 iterator 사용
				while(it.hasNext()) {	// 접속해있는 IP들에게 메시지들을 뿌려준다.
					send = new Sender(ip2,it.next(),new String(buf).trim());	// 순서대로 msg보내는 ip, 목적지 ip, msg내용
					send.sendMsg();
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(socket != null) {
				socket.close();
			}
		}
	}
}