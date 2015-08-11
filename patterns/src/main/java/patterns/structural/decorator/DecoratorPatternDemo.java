package patterns.structural.decorator;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
 * 
 * from: http://sourcemaking.com/design_patterns/decorator
 * 
 * You want to add behavior or state to individual objects at run-time. 
 * Inheritance is not feasible because it is static and applies to an entire class.
 * 
 */
public class DecoratorPatternDemo {
	public static void main(String[] args) {

		Shape circle = new Circle();

		Shape redCircle = new RedShapeDecorator(new Circle());

		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}
