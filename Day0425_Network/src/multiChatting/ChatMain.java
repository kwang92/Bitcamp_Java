package multiChatting;

public class ChatMain {
	public static void main(String[] args) {
		Thread t = new Thread(new ChatServer());
		t.start();
	}
}