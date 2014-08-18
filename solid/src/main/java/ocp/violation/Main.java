package ocp.violation;

public class Main {

	public static void main(String[] args) {
		Account checking = new Account("checking");
		Account saving = new Account("saving");
		checking.depost(10001);
		saving.depost(20002);
		saving.setInterestRate(.1);
		saving.getInterest();
		checking.setInterestRate(.1);
		checking.getInterest();
	}

}
