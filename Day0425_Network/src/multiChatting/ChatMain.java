package multiChatting;

public class ChatMain {
	public static void main(String[] args) {
	//	MyFrame f = new MyFrame();
		Thread t = new Thread(new ChatServer());
		t.start();
	}
}