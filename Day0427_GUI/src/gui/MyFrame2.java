package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MyFrame2 extends JFrame{
	private JTextField textField;
	public MyFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		this.setSize(271, 299);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Button");
		btnNewButton.setBounds(179, 10, 73, 23);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(12, 11, 166, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 43, 240, 208);
		panel.add(textArea);
		
		this.setVisible(true);
	}
}
