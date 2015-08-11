package patterns.creation.prototype;

public class Person implements Cloneable {
	private Car car;
	private String name;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Person (String name, String carName) {
		this.name = name;
		car = new Car (carName);
	}
	
	public Object clone() {
		// Shalow copy
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
