package ocp.fix;

public class Account {
	private AccountType act;
	
	public Account (String clsName) {
		try {
			Class c = Class.forName(clsName);
			act = (AccountType)c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void depost(int amt) {
		act.deposit(amt);
	}
}
