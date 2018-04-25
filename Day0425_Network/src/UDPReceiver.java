import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiver {
	public static void main(String[] args) {
		// UDP 방식으로 데이터를 받는 프로그램
		// 1. 데이터를 받기위해서 데이터가 들어오는 통로인 DatagramSocket 준비
		// 2. DatagramSocket에는 port만 설정
		// DatagramSocket을 통해서 들어오는 데이터를 받기위한 패킷준비
		// 소켓을 통해서 들어오는 패킷 수신
		
		try {
			DatagramSocket ds = new DatagramSocket(5000);
			while(true) {
				System.out.println("데이터 수신 대기중...");
				byte[] buf = new byte[512];
				
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				ds.receive(packet);
				String ip = packet.getAddress().getHostAddress();
		
				System.out.println(new String(buf).trim());
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