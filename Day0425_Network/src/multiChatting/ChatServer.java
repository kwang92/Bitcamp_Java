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
	private DatagramSocket socket;
	private Set<String> set;
	private Sender send;
	public ChatServer() {
		set = new HashSet<String>();
	}
	public void run() {
		try {
			socket = new DatagramSocket(5000);
			
			while(true) {
				System.out.println("데이터 수신 대기중...");
				byte[] buf = new byte[512];
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String ip = packet.getAddress().getHostAddress();
				set.add(ip);
				String ip2 = ip;
				System.out.println(new String(buf).trim());
				Iterator<String> it = set.iterator();
				while(it.hasNext()) {
					send = new Sender(ip2,it.next(),new String(buf).trim());
					send.sendMsg();
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
