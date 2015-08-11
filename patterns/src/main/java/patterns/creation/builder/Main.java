package patterns.creation.builder;

public class Main {

	public static void main(String[] args) {
		Builder builder_1 = new BuilderFactory().getBuilder("builder_1");
		Builder builder_2 = new BuilderFactory().getBuilder("builder_2");
		Component component_A1 = builder_1.createComponent_A();
		Component component_B1 = builder_1.createComponent_B();
		Component component_A2 = builder_2.createComponent_A();
		Component component_B2 = builder_2.createComponent_B();
		System.out.println("Object: "+component_A1.getClass().getName());
		System.out.println("Object: "+component_B1.getClass().getName());
		System.out.println("Object: "+component_A2.getClass().getName());
		System.out.println("Object: "+component_B2.getClass().getName());
	}

}
