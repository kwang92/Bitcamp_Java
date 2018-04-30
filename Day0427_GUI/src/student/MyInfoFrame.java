package student;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyInfoFrame extends JFrame{
	private JTextField textField;
	
	public MyInfoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(329, 356);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btn1 = new JButton("Button1");
		btn1.setBounds(204, 20, 97, 36);	// x, y 좌표  width, height 길이
		panel.add(btn1);
		
		textField = new JTextField();
		textField.setBounds(65, 28, 127, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("학생이름");
		lblNewLabel.setBounds(12, 31, 57, 15);
		panel.add(lblNewLabel);
		
		JCheckBox checkBox = new JCheckBox("체크박스 입니다");
		checkBox.setBounds(12, 79, 115, 23);
		panel.add(checkBox);
		checkBox.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();	// 라디오 버튼을 묶어줄 수 있는 그룹!
		JRadioButton radioBtn = new JRadioButton("라디오1");
		radioBtn.setBounds(12, 104, 121, 23);
		panel.add(radioBtn);
		JRadioButton radioBtn2 = new JRadioButton("라디오2");
		radioBtn2.setBounds(134, 104, 121, 23);
		panel.add(radioBtn2);
		
		group.add(radioBtn);	
		group.add(radioBtn2);
		
		
		Vector contents = new Vector();
		Stu a = new Stu();
		contents.add(a.getIn());
		
		JList list = new JList(contents);
		list.setBounds(12, 133, 289, 174);
		panel.add(list);
		
		
		
		this.setVisible(true);
	}
}
class Stu{
	public String[] getIn() {
		String[] info = {"abc","def","ghi"}; 
		return info;
	}
}
