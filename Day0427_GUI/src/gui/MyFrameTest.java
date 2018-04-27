package gui;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrameTest {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		
	}
}
class MyFrame extends JFrame{
	private JButton btn1;
	private JButton btn2;
	private JPanel panel1;
	private JPanel panel2;
	public MyFrame() {
		this.setTitle("내가 만든 프레임");
		this.setSize(500,400);
		
		btn1 = new JButton("click");
		panel1 = new JPanel();
		panel1.add(btn1);
		
		btn2 = new JButton("click");
		panel2 = new JPanel();
		panel2.add(btn2);
		
		this.add(panel1,"East");
		this.add(panel2, "West");
		this.setVisible(true);
		
	}
}
