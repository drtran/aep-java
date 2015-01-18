package com.creation.factorymethod;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 * 
 * from: http://sourcemaking.com/design_patterns/factory_method
 * 
 * A framework needs to standardize the architectural model for a range 
 * of applications, but allow for individual applications to define 
 * their own domain objects and provide for their instantiation.
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
