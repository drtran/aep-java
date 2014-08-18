package patterns.creation.abstractfactory;

public class Main {

	public static void main(String[] args) {
		Product_A productA1 = new ConcreteFactory_1().createProduct_A();
		Product_B productB1 = new ConcreteFactory_1().creaetProduct_B();
		Product_A productA2 = new ConcreteFactory_2().createProduct_A();
		Product_B productB2 = new ConcreteFactory_2().creaetProduct_B();
		System.out.println("Object: "+productA1.getClass().getName());
		System.out.println("Object: "+productA2.getClass().getName());
		System.out.println("Object: "+productB1.getClass().getName());
		System.out.println("Object: "+productB2.getClass().getName());
	}

}
