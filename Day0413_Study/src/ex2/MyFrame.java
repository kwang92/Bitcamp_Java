package ex2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame implements ActionListener
{
	
	private JFrame frm = new JFrame();
	private JPanel panel = new JPanel();
	private JTextField textField = new JTextField();
	private JTextArea textArea = new JTextArea();
	public MyFrame()
	{
		//textField셋팅
		textField.setColumns(20); //열의 크기(가로크기)
		textField.addActionListener(this);

		//textArea셋팅
		textArea.setLineWrap(true); //한줄이 너무 길면 자동으로 개행할지 설정
		textArea.setColumns(20); //열의 크기(가로크기)
		textArea.setRows(20); //행의 크기(세로크기)

		//기본 패널 셋팅
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(textField);
		panel.add(textArea);

		//기본 프래임 셋팅
		frm.setTitle("JTextArea Test");
		frm.setLocation(120, 120);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.add(panel);
		frm.pack();
		frm.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == textField)
		{
			String tmpStr = textField.getText();
			textArea.append(tmpStr+"\n");
			textField.setText("");
			textField.requestFocus();
			textArea.setCaretPosition(textArea.getDocument().getLength());
			textToFile();
		}
	}

	public void textToFile() {
		String message = textArea.getText();
		message = message.substring(0, message.length()-1);
		message.concat("\n");
		File file = new File("C:\\Users\\bit\\Desktop\\text\\test.txt");	// 님한테 맞는 경로로 수정
		FileWriter writer = null;

		try {
			// 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
			writer = new FileWriter(file, true);
			writer.write(message);
			writer.write("\n");
			writer.flush();

			System.out.println("DONE");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer != null) writer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}


	}
}