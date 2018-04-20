
public class Account {
	private int balance;
	
	public void deposit(int money) throws NegativeNumber_Exception{	// 입금은 0원 이상 가능
		// 더하기 전에 입력받은 수가 음수인지 양수인지 판단해서
		// NegativeNumberException 발생시키기
		
		if(money < 0) {
			throw new NegativeNumber_Exception();
		}
		balance += money;
	}
	public void withdraw(int money) throws NegativeNumber_Exception{
		
		if(money > balance) {
			throw new NegativeNumber_Exception();
		}
		
		balance -= money;
	}
	public void showBalance() {
		System.out.println("현재 잔고는 "+balance+"원 입니다.");
	}
}
