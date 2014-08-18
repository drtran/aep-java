package patterns.creation.factorymethod;

public class Main {

	public static void main(String[] args) {
		ConcreteCreator concreteCreator_1 = new ConcreteCreator("subclass_1");
		ConcreteCreator concreteCreator_2 = new ConcreteCreator("subclass_2");
		ParentClass subclass_1 = concreteCreator_1.factoryMethod();
		ParentClass subclass_2 = concreteCreator_2.factoryMethod();
		System.out.println("subclass: "+subclass_1.getClass().getName());
		System.out.println("subclass: "+subclass_2.getClass().getName());
	}

}
