package chatServer_UI;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;

public class ChatFrame extends JFrame{
	private TextField tf;
	private TextArea ta;
	private Sender sender;
	public ChatFrame() {
		
		tf = new TextField();
		ta = new TextArea();
		this.add(ta,"Center");
		this.add(tf,"South");
		
		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = tf.getText()+"\n";
				ta.append("나 : "+msg);
				tf.setText("");
				tf.requestFocus();
				
				sendServer(msg);
			}
		});
		
		ta.setEditable(false);
		this.setSize(300,200);
		this.setVisible(true);
		tf.requestFocus();
		
	}
	public void sendServer(String msg) {
		this.sender.sendToServer(msg);
	}
	public void setTa(String msg) {
		this.ta.append(msg+"\n");
	}
	public void setSender(Sender sender) {
		this.sender = sender;
	}
}
