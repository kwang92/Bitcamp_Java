import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		InetAddress ia = null;
		InetAddress ia2 = null;
		// 현재 컴퓨터의 ip 주소를 가지고 있는 객체 생성
		try {
			ia = InetAddress.getLocalHost();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ia.getHostAddress());
		System.out.println(ia.getHostName());
		
		try {
			ia2 = InetAddress.getByName("www.naver.com");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ia2.getHostAddress());
		System.out.println(ia2.getHostName());
		try {
			InetAddress[] ipArr = InetAddress.getAllByName("www.naver.com");
			for(int i = 0; i < ipArr.length; i++) {
				System.out.println((i+1)+"번째 "+ipArr[i].getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
