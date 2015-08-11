package patterns.creation.factorymethod_2;

public class ConcreteCreator implements Creator {

	private String subclass;
	public ConcreteCreator(String subclass) {
		this.subclass = subclass;
	}
	public ParentClass factoryMethod() {
		if (subclass.equals("subclass_1"))
			return new SubClass_1();
		else if (subclass.equals("subclass_2"))
			return new SubClass_2();
		return null;
	}

}
