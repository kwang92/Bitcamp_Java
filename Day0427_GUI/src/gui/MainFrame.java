package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300,200);
		frame.setTitle("main에서 실행하는 frame");
		
		JButton btn1 = new JButton("Click1");
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("Click2");
		frame.getContentPane().add(btn2);
		
		
		frame.getContentPane().setLayout(new GridLayout(2,3));	// 격자 레이아웃 3x3  크기에 맞춰서 컴포넌트들이 들어감
		
		JButton btn3 = new JButton("Click3");
		frame.getContentPane().add(btn3);
		
		JButton btn4 = new JButton("Click4");
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("Click5");
		frame.getContentPane().add(btn5);
	
		frame.setAlwaysOnTop(false);	// 프레임이 항상 위로 올라오게 만든다.
		frame.setResizable(false);	// 프레임 실행중 크기 변경 가능여부
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
