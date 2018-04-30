package mouseEvent;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MouseFrame extends JFrame implements MouseListener, ActionListener{
	private JPanel pan1;
	private JButton btn1;
	private JTextArea area;
	private ScrollPane scroll;
	
	public MouseFrame() {
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan1 = new JPanel();
		this.add(pan1,BorderLayout.CENTER);
		pan1.setLayout(null);
		
		btn1 = new JButton("눌러");
		btn1.setBounds(10, 10, 100, 100);		
		pan1.add(btn1);
		
		area = new JTextArea();
		
		
		scroll = new ScrollPane();
		scroll.add(area);
		
		pan1.add(scroll);
		scroll.setBounds(130, 10, 300, 400);
		btn1.addMouseListener(this);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {	// 마우스 클릭
		// TODO Auto-generated method stub
		this.area.append("Mouse Clicked  ");
		this.area.append("("+e.getX()+", "+e.getY()+")\n");
	}

	@Override
	public void mousePressed(MouseEvent e) {	// 마우스 눌렸을때
		// TODO Auto-generated method stub
		this.area.append("Mouse Pressed  ");
		this.area.append("("+e.getX()+", "+e.getY()+")\n");
	}

	@Override
	public void mouseReleased(MouseEvent e) {	// 마우스 땠을 때
		// TODO Auto-generated method stub
		this.area.append("Mouse Released  ");
		this.area.append("("+e.getX()+", "+e.getY()+")\n");
	}

	@Override
	public void mouseEntered(MouseEvent e) {	// 마우스가 컴포넌트 영역에 들어 왔을 때
		// TODO Auto-generated method stub
		this.area.append("Mouse Entered  ");
		this.area.append("("+e.getX()+", "+e.getY()+")\n");
	}

	@Override
	public void mouseExited(MouseEvent e) {		// 마우스가 컴포넌트 영역에서 나갔을 때
		// TODO Auto-generated method stub
		this.area.append("Mouse Exited  ");
		this.area.append("("+e.getX()+", "+e.getY()+")\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {	// 키 ㅎㅎ
		// TODO Auto-generated method stub
		
	}
}