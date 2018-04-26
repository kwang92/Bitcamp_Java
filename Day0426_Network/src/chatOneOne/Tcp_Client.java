package chatOneOne;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Tcp_Client {	// 프로그램 시작 시 Server에 연결, 연결이 되면 데이터 준비 및 전송
	private Socket socket;
	private static String IP = "192.168.0.26";
	private static int PORT = 5555;
	private Sender sender;
	private Reader reader;

	public boolean setConnect() {	// 서버와 소켓 연결
		try {
			socket = new Socket(IP,PORT);

			return true;

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void startComm() {	// 채팅기능 시작
		if(setConnect()) {	// startComm에서 setConnect 호출 ( 서버와의 연결 )
			
			//System.out.println(socket);
			sender = new Sender(socket);
			reader = new Reader(socket);
			sender.start();
			reader.start();
		}
	}
}
