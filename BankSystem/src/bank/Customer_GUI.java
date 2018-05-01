package bank;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;

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

	private Client_System cs;
	// /////////////////////////컴포넌트 getter, setter ///////////////////////////

	public JTextField getInput_Deposit() {
		return input_Deposit;
	}
	public void setInput_Deposit(JTextField input_Deposit) {
		this.input_Deposit = input_Deposit;
	}
	public JTextField getInput_Withdraw() {
		return input_Withdraw;
	}
	public void setInput_Withdraw(JTextField input_Withdraw) {
		this.input_Withdraw = input_Withdraw;
	}
	public JTextField getDestination() {
		return Destination;
	}
	public void setDestination(JTextField destination) {
		Destination = destination;
	}
	public JTextField getInput_Transfer() {
		return input_Transfer;
	}
	public void setInput_Transfer(JTextField input_Transfer) {
		this.input_Transfer = input_Transfer;
	}
	public JButton getDe_Btn() {
		return de_Btn;
	}
	public void setDe_Btn(JButton de_Btn) {
		this.de_Btn = de_Btn;
	}
	public JButton getWi_Btn() {
		return wi_Btn;
	}
	public void setWi_Btn(JButton wi_Btn) {
		this.wi_Btn = wi_Btn;
	}
	public JButton getTran_Btn() {
		return tran_Btn;
	}
	public void setTran_Btn(JButton tran_Btn) {
		this.tran_Btn = tran_Btn;
	}
	public JButton getShow_Btn1() {
		return show_Btn1;
	}
	public void setShow_Btn1(JButton show_Btn1) {
		this.show_Btn1 = show_Btn1;
	}
	public JButton getShow_Btn2() {
		return show_Btn2;
	}
	public void setShow_Btn2(JButton show_Btn2) {
		this.show_Btn2 = show_Btn2;
	}
	public JList getList() {
		return list;
	}
	public void setList(JList list) {
		this.list = list;
	}
	public void setBalanceLabel(String balance) {
		this.balance_Label.setText(balance);
		this.balance_Label.setVisible(true);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	public Customer_GUI(String account, String password) {
		this.setSize(300,300);
		this.setTitle("Customer");
		this.setVisible(true);
		
		this.build_Deposit();
		this.build_Withdraw();
		this.build_Transfer();
		this.build_Inquiry();
		getContentPane().add(tab);
		System.out.println("7");
		
		
		cs = new Client_System(account, password);
		startEvent();     // 버튼 이벤트들 시작
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void startEvent() {
		de_Btn.addActionListener(new ActionListener() {	// 입금버튼 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int money = Integer.parseInt(input_Deposit.getText());
				System.out.println(money+"원 입금");
				input_Deposit.setText("");
				cs.getTmpCus().setDataType("COMMIT");
				cs.getTmpCus().getAccount().deposit(money);
				cs.sendCustomer();
			}
		});
		wi_Btn.addActionListener(new ActionListener() {	// 출금버튼 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int money = Integer.parseInt(input_Withdraw.getText());
				System.out.println(money+"원 출금");
				input_Withdraw.setText("");
				cs.getTmpCus().getAccount().withdraw(money);
				cs.getTmpCus().setDataType("COMMIT");
				cs.sendCustomer();
			}
		});
		tran_Btn.addActionListener(new ActionListener() {	// 이체버튼 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int money = Integer.parseInt(input_Transfer.getText());
				System.out.println(money+"원 송금");
				input_Transfer.setText("");
				cs.getTmpCus().getAccount().withdraw(money);	// 본인 계좌의 금액만큼 출금
				cs.getTmpCus().setDataType("COMMIT");			// 변경된 사항 commit
				cs.sendCustomer();								// server에 전송해서 적용
				
				String my_Account = cs.getTmpCus().getAccount().getAccount();	// 자기 자신의 계좌번호 저장
				String password = cs.getTmpCus().getAccount().getPassword(); 	// 자기 자신의 비밀번호도 저장
				String target_Account = Destination.getText();	// target 계좌번호
				Customer target = new Customer(target_Account,"target");	// target 계좌번호로 된 Customer객체 생성
				cs.setTmpCus(target);										// tmpCus를 target customer로 변경
				cs.getTmpCus().setDataType("REQ");							// target으로 변경된 객체정보를 서버에 요청
				cs.sendCustomer();											// 요청전송
				// 서버에게 target Customer를 받아서 tmpCus에 저장됬다고 가정
				cs.getTmpCus().getAccount().deposit(money);		// tmpCus(target)에 금액만큼 입금				
				cs.getTmpCus().setDataType("COMMIT");			// 변경된 사항 commit
				cs.sendCustomer();								// 서버에 전송, 적용
				
				cs.setTmpCus(new Customer(my_Account,password));
				cs.getTmpCus().setDataType("REQ");
				cs.sendCustomer();
				System.out.println("이체완료");
			}
		});
		show_Btn1.addActionListener(new ActionListener() {	// 거래내역버튼 이벤트
			@Override										// 접속중인 고객에 대응하는 거래내역정보를 서버로부터 받는다.
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		show_Btn2.addActionListener(new ActionListener() {	// 잔액조회버튼 이벤트
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String balance = cs.getTmpCus().getAccount().getBal()+"";
				setBalanceLabel(balance);
				System.out.println("현재 잔액: "+cs.getTmpCus().getAccount().getBal());
			}
		});
	}
	public void build_Deposit() {
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
	public void build_Withdraw() {
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
	public void build_Transfer() {
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
	public void build_Inquiry() {
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
		list.setBounds(12, 43, 255, 179);
		inquiry_Panel.add(list);
		list.setVisible(false);
		balance_Label = new JLabel("");
		balance_Label.setVisible(false);
		balance_Label.setBounds(108, 124, 57, 15);
		inquiry_Panel.add(balance_Label);
	}

}
