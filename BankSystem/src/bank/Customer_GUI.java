package bank;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class Customer_GUI extends JFrame{
	private JTabbedPane tab;	// 입금 , 출금, 송금, 조회, 총 4개의 tab을 담을 tab panel
	private JPanel deposit_Panel;	// 입금 GUI 패널
	private JTextField input_Deposit; // 입금금액 입력받는 textField
	private JPanel withdraw_Panel;	// 출금 GUI 패널
	private JPanel transfer_Panel;	// 송금 GUI 패널
	private JPanel inquiry_Panel;	// 조회 GUI 패널
	private JTextField input_Withdraw;	// 출금금액 입력받는 textField
	private JTextField Destination;		// 이체 대상 계좌 입력받는 textField
	private JTextField input_Transfer;	// 이체할 금액 입력받는 textField
	private JButton de_Btn;				// 입금완료 버튼
	private JButton wi_Btn;				// 출금완료 버튼
	private JButton tran_Btn;			// 이체완료 버튼
	private JButton show_Btn1;			// 거래내역 조회 버튼
	private JButton show_Btn2;			// 잔액조회 버튼
	private JLabel balance_Label;		// 잔액출력 Label
	private JList list;					// 거래내역 출력 List
	private Client_System cs;			// 현재 GUI에서 관리하고 있는 Client_System 객체를 저장할 변수

	public Customer_GUI(String name, String account, String password) {	 // Customer GUI 생성자
		this.setSize(300,300);
		this.setTitle("Customer");
		this.setVisible(true);
		this.build_Deposit();
		this.build_Withdraw();
		this.build_Transfer();
		this.build_Inquiry();

		///////////////////////////////////////////////각 패널들 생성 완료

		cs = new Client_System(name, account, password);	// 현재 관리할 cs 객체 생성
		startEvent();     									// 버튼 이벤트들 시작

		getContentPane().add(tab);							// 생성한 모든 tab Panel들을  mainFrame에 넣어준다.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// GUI종료 시 프로그램도 자동종료
	}

	public void setBalanceLabel(String balance) {	// 잔액 출력 Label 값 설정 후 Visible을 true로 변환하는 메소드
		this.balance_Label.setText(balance);
		this.balance_Label.setVisible(true);
	}
	public boolean checkAccess() {	// 비밀번호 일치여부를 boolean값으로 return 해주는 메소드
		String pwd = JOptionPane.showInputDialog("비밀번호를 입력하세요");
		if(pwd.equals(cs.getTmpCus().getAccount().getPassword())) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.","경고",JOptionPane.WARNING_MESSAGE);

		return false;
	}
	public void startEvent() {	// button 이벤트 동작시키는 메소드
		de_Btn.addActionListener(new ActionListener() {	// 입금버튼 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!checkAccess()) {
					input_Deposit.setText("");
					return;
				}
				int money = Integer.parseInt(input_Deposit.getText());
				System.out.println(money+"원 입금");
				input_Deposit.setText("");
				cs.getTransAction().setJob("DE");
				cs.getTransAction().setMoney(money);
				cs.sendCustomer();
			}
		});
		wi_Btn.addActionListener(new ActionListener() {	// 출금버튼 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!checkAccess()) {
					input_Withdraw.setText("");
					return;
				}
				int money = Integer.parseInt(input_Withdraw.getText());
				System.out.println(money+"원 출금");
				input_Withdraw.setText("");
				cs.getTransAction().setJob("WD");
				cs.getTransAction().setMoney(money);
				cs.sendCustomer();
			}
		});
		tran_Btn.addActionListener(new ActionListener() {	// 이체버튼 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!checkAccess()) {
					Destination.setText("");
					input_Transfer.setText("");
					return;
				}
				int money = Integer.parseInt(input_Transfer.getText());
				String target = Destination.getText();
				Destination.setText("");
				input_Transfer.setText("");
				cs.getTransAction().setJob("TR");
				cs.getTransAction().setMoney(money);
				cs.getTransAction().setTarget(target);
				cs.sendCustomer();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {}
				JOptionPane.showConfirmDialog(null, "송금완료!"); 
			}
		});
		String name = cs.getTmpCus().getName();
		show_Btn1.addActionListener(new ActionListener() {	// 거래내역버튼 이벤트
			@Override										// 접속중인 고객에 대응하는 거래내역정보를 서버로부터 받는다.
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!checkAccess())
					return;
				

				String path = "C:\\Users\\bit\\Desktop\\ryu\\store\\BankSystem\\src\\record"+name+".txt";
				try {
					BufferedReader in = new BufferedReader(new FileReader(path));
					String line;
					DefaultListModel model = new DefaultListModel();
					while((line = in.readLine()) != null) {
						model.addElement(line);
					}
					list.setModel(model);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "거래내역이 없습니다.","거래내역 오류",JOptionPane.WARNING_MESSAGE);
				} catch (IOException e1) {}

				balance_Label.setVisible(false);
				list.setVisible(true);
			}
		});
		show_Btn2.addActionListener(new ActionListener() {	// 잔액조회버튼 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!checkAccess()) 
					return;

				list.setVisible(false);
				cs.getTransAction().setJob("REQ");
				cs.sendCustomer();
				String balance = "현재 잔액은 "+cs.getTmpCus().getAccount().getBal()+"원 입니다.";
				setBalanceLabel(balance);
			}
		});
	}
	public void build_Deposit() {	// 입금패널 컴포넌트 생성 메소드
		this.deposit_Panel = new JPanel();
		this.input_Deposit = new JTextField();
		input_Deposit.setBounds(56, 113, 141, 21);
		deposit_Panel.setLayout(null);
		deposit_Panel.add(input_Deposit);

		this.tab = new JTabbedPane();
		tab.add("입금", deposit_Panel);

		JLabel lblNewLabel = new JLabel("입금액 입력");
		lblNewLabel.setBounds(56, 89, 133, 15);
		deposit_Panel.add(lblNewLabel);

		de_Btn = new JButton("입금");
		de_Btn.setBounds(84, 144, 97, 23);
		deposit_Panel.add(de_Btn);
	}
	public void build_Withdraw() {	// 출금패널 컴포넌트 생성 메소드
		this.withdraw_Panel = new JPanel();
		tab.add("출금", withdraw_Panel);
		withdraw_Panel.setLayout(null);

		input_Withdraw = new JTextField();
		input_Withdraw.setBounds(62, 112, 141, 21);
		withdraw_Panel.add(input_Withdraw);

		JLabel label = new JLabel("출금액 입력");
		label.setBounds(62, 87, 133, 15);
		withdraw_Panel.add(label);

		wi_Btn = new JButton("출금");
		wi_Btn.setBounds(85, 143, 97, 23);
		withdraw_Panel.add(wi_Btn);
	}
	public void build_Transfer() {	// 송금패널 컴포넌트 생성 메소드
		this.transfer_Panel = new JPanel();
		tab.add("송금", transfer_Panel);
		transfer_Panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("상대방 계좌");
		lblNewLabel_1.setBounds(12, 36, 133, 15);
		transfer_Panel.add(lblNewLabel_1);

		Destination = new JTextField();
		Destination.setBounds(12, 61, 121, 21);
		transfer_Panel.add(Destination);
		Destination.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("이체할 금액");
		lblNewLabel_2.setBounds(12, 92, 99, 15);
		transfer_Panel.add(lblNewLabel_2);

		input_Transfer = new JTextField();
		input_Transfer.setBounds(12, 117, 121, 21);
		transfer_Panel.add(input_Transfer);
		input_Transfer.setColumns(10);

		tran_Btn = new JButton("이체");
		tran_Btn.setBounds(12, 159, 97, 23);
		transfer_Panel.add(tran_Btn);
	}
	public void build_Inquiry() {	// 조회패널 컴포넌트 생성 메소드
		this.inquiry_Panel = new JPanel();
		tab.add("조회", inquiry_Panel);
		inquiry_Panel.setLayout(null);

		show_Btn1 = new JButton("거래내역");
		show_Btn1.setBounds(12, 10, 97, 23);
		inquiry_Panel.add(show_Btn1);

		show_Btn2 = new JButton("잔액");
		show_Btn2.setBounds(170, 10, 97, 23);
		inquiry_Panel.add(show_Btn2);

		list = new JList();
		list.setAutoscrolls(true);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBounds(12, 43, 255, 179);
		inquiry_Panel.add(list);


		list.setVisible(false);
		balance_Label = new JLabel("");
		balance_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		balance_Label.setVisible(false);
		balance_Label.setBounds(24, 105, 232, 41);
		inquiry_Panel.add(balance_Label);
	}
}
