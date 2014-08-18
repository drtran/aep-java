package ocp.violation;

public class Account {
	private String acctType;
	private int amt;
	private double interestRate;
	
	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Account (String acctType) {
		this.acctType = acctType;
	}
	
	public void depost(int amt) {
		this.amt = amt;
	}
	
	public double getInterest() {
		if ("saving".equals(acctType))
			return interestRate * amt;
		return 0;
	}
}
