package com.creation.factorymethod;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 *
 */
public class FactoryMethodPatternDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		Shape circle = shapeFactory.getShape("CIRCLE");
		circle.draw();

		Shape rectangle = shapeFactory.getShape("RECTANGLE");
		rectangle.draw();

		Shape square = shapeFactory.getShape("SQUARE");
		square.draw();
	}
}
