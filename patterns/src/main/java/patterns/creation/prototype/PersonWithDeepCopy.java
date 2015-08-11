package patterns.creation.prototype;

public class PersonWithDeepCopy extends Person {
	
	public PersonWithDeepCopy(String name, String carName) {
		super(name, carName);
	}

	public Object clone() {
		// Deep copy
		PersonWithDeepCopy person = new PersonWithDeepCopy(getName(), getCar().getName());
		return person;
	}
}
