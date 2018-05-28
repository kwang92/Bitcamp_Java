package model;

public class Loan {
	/*
	 * 	<th>회차</th>
			<th>상환액</th>
			<th>상환원금</th>
			<th>이자</th>
			<th>상환총액</th>
			<th>잔액</th>
	 * */
	private int num;
	private int repayTotal;
	private int repayOrigin;
	private int interest;
	private int repaySum;
	private int repayRemain;
	
	public Loan(int num, int rT, int rO, int inst, int rS, int rR) {
		this.num = num;
		this.repayTotal = rT;
		this.repayOrigin = rO;
		this.interest = inst;
		this.repaySum = rS;
		this.repayRemain = rR;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getRepayTotal() {
		return repayTotal;
	}

	public void setRepayTotal(int repayTotal) {
		this.repayTotal = repayTotal;
	}

	public int getRepayOrigin() {
		return repayOrigin;
	}

	public void setRepayOrigin(int repayOrigin) {
		this.repayOrigin = repayOrigin;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public int getRepaySum() {
		return repaySum;
	}

	public void setRepaySum(int repaySum) {
		this.repaySum = repaySum;
	}

	public int getRepayRemain() {
		return repayRemain;
	}

	public void setRepayRemain(int repayRemain) {
		this.repayRemain = repayRemain;
	}
	
}
