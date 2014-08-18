package ocp.fix;

public class CheckingAccount extends AccountType {

	@Override
	public void deposit(int amt) {
		System.out.println();
		System.out.println();
		System.out.println("Amount deposited in checking account: " + amt);
		System.out.println();
		System.out.println();
	}

}
