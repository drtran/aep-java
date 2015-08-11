package patterns.creation.builder;

public class BuilderFactory {
	public Builder getBuilder(String builderName) {
		Builder builder = null;
		if (builderName.equals("builder_1")) 
			builder = new ConcreteBuilder_1();
		else if (builderName.equals("builder_2"))
			builder = new ConcreteBuilder_2();
		return builder;
	}
}
