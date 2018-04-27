package event;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

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

		JButton btn = new JButton("눌러봐");
		/////////// 버튼 이벤트 작성 ///////////	
//		btn.addActionListener(new MyActionListener());	// 컴포넌트에 이벤트를 넣어준다. , 클래스 생성방식
		btn.addActionListener(new ActionListener() {	// 무명클래스 방식
			boolean bt = true;
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(bt = !bt) {
					btn.setText("왜누름");
				}else {
					btn.setText("눌러봐");
				}
			}
		});



		btn.setBounds(87, 10, 97, 23);
		pan1.add(btn);
		


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