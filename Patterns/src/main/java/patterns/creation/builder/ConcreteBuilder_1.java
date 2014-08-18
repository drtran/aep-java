package patterns.creation.builder;

public class ConcreteBuilder_1 implements Builder {

	public Component createComponent_A() {
		return new Component_A();
	}

	public Component createComponent_B() {
		return new Component_B();
	}

}
