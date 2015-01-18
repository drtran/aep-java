package patterns.creation.abstractfactory;

import com.creation.factorymethod.Shape;
import com.creation.factorymethod.ShapeFactory;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm
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