package patterns.structural.composite;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/composite_pattern.htm
 * 
 * from: http://sourcemaking.com/design_patterns/composite
 * 
 * Application needs to manipulate a hierarchical collection of 
 * "primitive" and "composite" objects. Processing of a primitive object 
 * is handled one way, and processing of a composite object is handled 
 * differently. Having to query the "type" of each object before attempting 
 * to process it is not desirable.
 * 
 */
public class CompositePatternDemo {
	public static void main(String[] args) {

		Employee CEO = new Employee("John", "CEO", 30000);

		Employee headSales = new Employee("Robert", "Head Sales", 20000);

		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

		CEO.add(headSales);
		CEO.add(headMarketing);

		headSales.add(salesExecutive1);
		headSales.add(salesExecutive2);

		headMarketing.add(clerk1);
		headMarketing.add(clerk2);

		// print all employees of the organization
		System.out.println(CEO);

		for (Employee headEmployee : CEO.getSubordinates()) {
			System.out.println(headEmployee);

			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println(employee);
			}
		}
	}
}
