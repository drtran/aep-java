package patterns.behavior.nullobject;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/null_object_pattern.htm
 * 
 * From:  http://sourcemaking.com/design_patterns/null_object
 * 
 * Given that an object reference may be optionally null, 
 * and that the result of a null check is to do nothing or 
 * use some default value, how can the absence of an object — 
 * the presence of a null reference — be treated transparently?
 *   
 */
public class NullObjectPatternDemo {
	public static void main(String[] args) {

		AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
		AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
		AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
		AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

		System.out.println("Customers");
		System.out.println(customer1.getName());
		System.out.println(customer2.getName());
		System.out.println(customer3.getName());
		System.out.println(customer4.getName());
	}
}
