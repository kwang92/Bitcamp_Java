package thread3;

public class User implements Runnable{
	BankAccount account;
	
	public void run() {
		for(int i = 0; i < 50; i++) {
			
			account.withdraw(10000);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			account.deposit(10000);
			
		}
		account.showBalance();
		
	}
	public User() {
		account = new BankAccount();
	}
	public User(BankAccount account) {
		this.account = account;
	}
}