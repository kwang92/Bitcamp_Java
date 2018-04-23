package thread3;

public class BankAccount {
	private int balance;
	
	public synchronized void deposit(int amount) {
		balance -= amount;
	}
	public synchronized void withdraw(int amount) {
		balance += amount;
	}
	public int getBalance() {
		return this.balance;
	}
	public void showBalance() {
		System.out.println("잔액 : "+this.getBalance());
	}
}