
public class AccountTest {
	public static void main(String[] args) {
		Account myAccount = new Account();
		// 사용자 정의 예외처리 예시

		try {
			myAccount.deposit(100000000);
			System.out.println("입금완료");
		}catch(NegativeNumber_Exception e) {
			e.printStackTrace();
			System.out.println("입금금액이 잘못 되었습니다.");
		}
		
		try {
			myAccount.withdraw(200000000);
		}catch(NegativeNumber_Exception e) {
			e.printStackTrace();
			System.out.println("출금금액이 잔액보다 많습니다.");
		}
		
	}
}
