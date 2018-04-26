package chatOneOne;

public class ClientMain {
	public static void main(String[] args) {
		Tcp_Client cli = new Tcp_Client();
		cli.startComm();
	}
}