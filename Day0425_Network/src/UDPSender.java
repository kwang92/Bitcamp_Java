import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPSender {
	public static void main(String[] args) {
		// UDP 방식으로 데이터를 보내는 프로그램
		// 1. 목적지의 ip주소와 port번호가 필요
		// 2. 데이터를 DatagramPacket 준비
		// 3. IP와 port정보를 지정
		// 4. 데이터 전송 ( 데이터 나가는 통로 : DatagramSocket )
		// 5. 전송할 데이터는 byte[]로 준비.
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			InetAddress ip = InetAddress.getByName("192.168.0.34");
			
			DatagramPacket packet = null;
			byte[] buf;	// data를 담을 byte배열
			Scanner input = new Scanner(System.in);
			
			while(true) {	// quit 입력 시 까지 데이터 계속 전송
				System.out.println("Data 입력: ");
				String msg = input.next();
				if(msg.equals("quit")) {
					break;
				}
				buf = msg.getBytes();
				packet = new DatagramPacket(buf, buf.length,ip,5000);
				ds.send(packet);
				
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