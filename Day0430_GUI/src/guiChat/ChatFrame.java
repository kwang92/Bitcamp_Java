package guiChat;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ChatFrame extends JFrame{
	private TextField tf;
	private TextArea ta;
	private JButton btn;
	private Sender sender;

	public ChatFrame() {
		ta = new TextArea();
		ta.setBounds(10, 5, 300, 161);
		tf = new TextField();
		tf.setBounds(10, 172, 225, 23);

		
		ta.setEditable(false);
		getContentPane().setLayout(null);
		
		getContentPane().add(ta);
		getContentPane().add(tf);
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});
		
		ta.setEditable(false);
		
		btn = new JButton("send");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = tf.getText()+"\n";
				ta.append("나 : "+msg);
				tf.setText("");
				tf.requestFocus();
				
				sendServer(msg);
			}
		});
		btn.setBounds(241, 172, 69, 23);
		getContentPane().add(btn);
		this.setSize(338,244);
		this.setVisible(true);
		tf.requestFocus();
		
		
		
	}
	public void sendMsg() {
		String msg = tf.getText()+"\n";
		ta.append("나 : "+msg);
		tf.setText("");
		tf.requestFocus();
		
		sendServer(msg);
	}
	public String getIP() {
		String ip = JOptionPane.showInputDialog(null, "서버 IP입력", null);
			
		return ip;
	}
	public void sendServer(String msg) {
		this.sender.sendToServer(msg);
	}
	public void setTa(String msg) {
		this.ta.append(msg);
	}
	public void setSender(Sender sender) {
		this.sender = sender;
	}
}
