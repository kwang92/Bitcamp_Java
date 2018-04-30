package event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	private JButton btnEvent;
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,500);
		this.setTitle("이벤트 처리");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnEvent = new JButton("이벤트 발생!");
		btnEvent.setBounds(12, 31, 114, 23);

		
		btnEvent.addActionListener(new ActionListener() {	// 익명클래스 방식으로 이벤트 정의

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getActionCommand());
				JOptionPane.showMessageDialog(null, "버튼 이벤트발생");	// Button 클릭 시 다이얼로그창 alert
			}
		});
		panel.add(btnEvent);
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 프레임 닫을 시 프로그램을 종료시켜준다.
	}
}