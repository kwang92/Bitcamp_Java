package event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class KeyEvent_Ex extends JFrame{
	private JTextArea ja;
	public KeyEvent_Ex() {
		this.setSize(200,300);
		
		ja = new JTextArea();
		ja.setBounds(28, 23, 116, 177);
		ja.setEditable(false);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		class MyKeyListener implements KeyListener{

			@Override
			public void keyTyped(KeyEvent e) {
				
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					JOptionPane.showMessageDialog(null, "엔터가 눌림!!");
				}
				else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					JOptionPane.showMessageDialog(null, "스페이스바가 눌림!!");
				}
				else if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
					JOptionPane.showMessageDialog(null, "쉬프트가 눌림!!");
				}
			}
			
		}
		this.addKeyListener(new MyKeyListener());
		getContentPane().setLayout(null);
		getContentPane().add(ja);
	}
}
