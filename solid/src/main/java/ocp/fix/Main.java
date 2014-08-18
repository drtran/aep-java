package ocp.fix;

/* 
 * Class should be open for 'extension' but 'close' for change
 *  
 * */
public class Main {

	public static void main(String[] args) {
		Account checking = new Account("ocp.CheckingAccount");
		Account saving = new Account("ocp.SavingAccount");
		checking.depost(10001);
		saving.depost(20002);
	}

}
