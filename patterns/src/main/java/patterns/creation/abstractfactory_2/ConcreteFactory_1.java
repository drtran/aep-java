package patterns.creation.abstractfactory_2;

public class ConcreteFactory_1 implements AbstractFactory {

	public Product_A createProduct_A() {
		return new Product_A1();
	}

	public Product_B creaetProduct_B() {
		return new Product_B1();
	}

}
