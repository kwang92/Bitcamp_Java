package multiChatting;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPSenderThread implements Runnable{
	public void run() {
		try {
			//패킷을 내 보내야 하기 때문에 데이터를 내보낼 소켓을 준비
			//UDP 방식에서 소켓은 DatagramSocket
			DatagramSocket socket = new DatagramSocket();
			//데이터를 보낼 목적지의 ip주소를 저장할 객체
			InetAddress ia = InetAddress.getByName("192.168.0.34");
			//데이터를 내 보내기 위해서 데이터를 패킷 참조 변수 선언
			DatagramPacket packet = null;
			//데이터를 담을 byte[] 준비
			byte[] buf;
			
			//계속해서 반복하면서 키보드로 부터 입력을 받음
			Scanner scan = new Scanner(System.in);
			while(true) {
				String msg = scan.nextLine();
				if(msg.equals("quit")) {
					break;
				}
				buf = msg.getBytes();
				packet = new DatagramPacket(buf, buf.length,ia,5000);
				//패킷 만들고 통로(soket)을 이용해서 전송
				socket.send(packet);
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
