package multiChatting;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Sender{
	private String ip;
	private String msg;
	public Sender(String ip2,String ip, String msg) {
		this.ip = ip;
		this.msg = ip2+": "+msg;
	}
	public void sendMsg() {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			InetAddress inet = InetAddress.getByName(this.ip);

			DatagramPacket packet = null;
			byte[] buf;	// data를 담을 byte배열
			buf = this.msg.getBytes();
			
			packet = new DatagramPacket(buf, buf.length,inet,5000);
			ds.send(packet);



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
