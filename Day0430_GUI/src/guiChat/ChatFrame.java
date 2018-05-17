package guiChat;


import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ChatFrame extends JFrame{
	private TextField tf;
	private TextArea ta;
	private JButton btn;
	private Sender sender;
	private JButton btnNick;
	private JTextField tfNick;
	private String nickName;
	
	public ChatFrame() {
		ta = new TextArea();
		ta.setBounds(10, 5, 225, 161);
		tf = new TextField();
		
		tf.setBounds(10, 172, 225, 23);
		this.nickName = "NoName";
		
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
		
		btnNick = new JButton("set");
		btnNick.setBounds(241, 46, 69, 23);
		btnNick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nickName = tfNick.getText();
				tfNick.setText("");
			}
		});
		
		getContentPane().add(btnNick);
		
		tfNick = new JTextField();
		tfNick.setBounds(240, 23, 70, 21);
		getContentPane().add(tfNick);
		tfNick.setColumns(10);
		this.setSize(338,244);
		this.setVisible(true);
		tf.requestFocus();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void sendMsg() {
		String msg = tf.getText()+"\n";
		ta.append("나 : "+msg);
		tf.setText("");
		tf.requestFocus();
		
		sendServer(nickName+" : "+msg);
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
