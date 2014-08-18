package patterns.creation.abstractfactory;

public class ConcreteFactory_2 implements AbstractFactory {

	public Product_A createProduct_A() {
		return new Product_A2();
	}

	public Product_B creaetProduct_B() {
		return new Product_B2();
	}

}
