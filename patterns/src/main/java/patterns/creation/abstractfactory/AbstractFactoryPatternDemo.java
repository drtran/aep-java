package patterns.creation.abstractfactory;

import com.creation.factorymethod.Shape;
import com.creation.factorymethod.ShapeFactory;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm
 * 
 * from: http://sourcemaking.com/design_patterns/abstract_factory 
 * 
 * If an application is to be portable, it needs to encapsulate platform dependencies. 
 * These "platforms" might include: windowing system, operating system, database, etc. 
 * Too often, this encapsulation is not engineered in advance, 
 * and lots of #ifdef case statements with options for all currently 
 * supported platforms begin to procreate like rabbits throughout the code.
 * 
 */
public class AbstractFactoryPatternDemo {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		Shape circle = shapeFactory.getShape("CIRCLE");
		circle.draw();

		Shape rectangle = shapeFactory.getShape("RECTANGLE");
		rectangle.draw();

		Shape square = shapeFactory.getShape("SQUARE");
		square.draw();

		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

		Color red = colorFactory.getColor("RED");
		red.fill();

		Color green = colorFactory.getColor("Green");
		green.fill();

		Color blue = colorFactory.getColor("BLUE");
		blue.fill();
	}
}