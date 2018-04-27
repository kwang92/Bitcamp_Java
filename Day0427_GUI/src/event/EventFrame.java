package event;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import java.awt.Font;

public class EventFrame extends JFrame {
	// 	Event중 컴포넌트를 조작하는 행위 : Action (버튼클릭, 글자입력, 리스트 목록선택.....등)
	//	Action 처리하는 클래스 ActionListener
	private JPanel pan1;
	
	public EventFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이벤트 처리하기");
		this.setSize(300,200);

		pan1 = new JPanel();
		getContentPane().add(pan1);
		pan1.setLayout(null);

		JButton btn1 = new JButton("눌러봐");
		/////////// 버튼 이벤트 작성 ///////////	
//		btn.addActionListener(new MyActionListener());	// 컴포넌트에 이벤트를 넣어준다. , 클래스 생성방식
		btn1.addActionListener(new ActionListener() {	// 무명클래스 방식
			boolean bt = true;
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(bt = !bt) {
					btn1.setText("눌러봐");
				}else {
					btn1.setText("왜누름");
				}
			}
		});



		btn1.setBounds(12, 10, 97, 23);
		pan1.add(btn1);
		
		JButton btn2 = new JButton("니 이름은 뭐니?");
		btn2.setBounds(121, 10, 138, 23);
		pan1.add(btn2);
		
		JLabel label1 = new JLabel("New label");
		label1.setFont(new Font("굴림", Font.PLAIN, 21));
		label1.setBounds(58, 62, 179, 73);
		pan1.add(label1);
		label1.setVisible(false);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				label1.setText("난 류광민이야");
				label1.setVisible(true);
			}
		});

		this.setVisible(true);
	}
}
class MyActionListener implements ActionListener{
	// ActionListener를 구현하는 구현 클래스 //
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}