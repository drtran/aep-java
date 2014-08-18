package patterns.creation.builder;

public class ConcreteBuilder_2 implements Builder {

	public Component createComponent_A() {
		return new NewComponent_A();
	}

	public Component createComponent_B() {
		return new NewComponent_B();
	}

}
