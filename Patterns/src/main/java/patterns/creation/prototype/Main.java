package patterns.creation.prototype;

public class Main {
	public static void main(String[] args) {
		System.out.println("--- Shalow Copy ---");
		shallowCopy();
		System.out.println("--- Deep Copy ---");
		deepCopy();
	}
	
	public static void shallowCopy () {
		Person person = new Person("Person-A", "Civic");
		Person personClone = (Person) person.clone();
		print(person);
		print(personClone);
		personClone.setName("Person-B");
		personClone.getCar().setName("Accord");
		System.out.println("--- after change ---");
		print(person);
		print(personClone);
	}
	
	public static void deepCopy () {
		PersonWithDeepCopy person = new PersonWithDeepCopy("Person-A", "Civic");
		PersonWithDeepCopy personClone = (PersonWithDeepCopy) person.clone();
		print(person);
		print(personClone);
		personClone.setName("Person-B");
		personClone.getCar().setName("Accord");
		System.out.println("--- after change ---");
		print(person);
		print(personClone);
	}

	public static void print(Person person) {
		System.out.println("person-name="+person.getName());
		System.out.println("car-name="+person.getCar().getName());
	}
}
