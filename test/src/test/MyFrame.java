package test;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame{
	private JPanel jp;
	private JButton btn;
	public MyFrame() {
		this.setSize(300,300);
		jp = new JPanel();
		btn = new JButton("¹öÆ°");
		
		this.jp.add(btn);
		this.setShape(new java.awt.geom.Rectangle2D.Double(0, 0, 500, 500));
		this.jp.setOpaque(true);
		/*
		this.jp.setBackground(new java.awt.Color(204,166,166));
		this.jp.setForeground(new java.awt.Color(255,0,0));
		*/
		
		this.add(jp);
		this.setVisible(true);
	}
}
