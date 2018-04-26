package multiChatting;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	private JTextField jf;
	private JButton btn;
	private JTextArea text;
	private JPanel panel1;
	private JPanel panel2;
	public MyFrame() {
		this.setSize(400,700);
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		this.jf = new JTextField(30);
		this.text = new JTextArea(this.WIDTH,400);
		

		this.btn = new JButton("입력");
		
		panel1.add(text);
		panel2.add(jf);
		this.setLayout(new BorderLayout());
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.SOUTH);
		//this.add(btn);
	
		this.setVisible(true);
	}
}
