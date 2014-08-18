package ocp.fix;

public class SavingAccount extends AccountType {

	@Override
	public void deposit(int amt) {
		System.out.println();
		System.out.println();
		System.out.println("Amount deposited in saving account: " + amt);
		System.out.println();
		System.out.println();	}

}
