package event;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class WonToDollar extends JFrame{
	private JTextField won;
	private JPanel panel;
	private JLabel dollar;
	private JButton btn1;
	public WonToDollar() {
		this.setSize(300,300);
		this.setVisible(true);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		won = new JTextField();
		won.setBounds(12, 33, 116, 21);
		panel.add(won);
		won.setColumns(10);
		
		dollar = new JLabel();
		dollar.setFont(new Font("굴림", Font.PLAIN, 21));
		dollar.setVisible(false);
		dollar.setBounds(69, 123, 153, 82);
		panel.add(dollar);
		
		
		btn1 = new JButton("환전");
		btn1.setBounds(154, 32, 97, 23);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(won.getText() != null) {
					int doll = Integer.parseInt(won.getText()) * 1067;
					dollar.setText(doll+"");
					dollar.setVisible(true);
				}
			}
		});
		
		panel.add(btn1);
		
		JLabel lblNewLabel = new JLabel("원화를 입력하세요");
		lblNewLabel.setBounds(12, 8, 116, 15);
		panel.add(lblNewLabel);
		
		
	}
}
