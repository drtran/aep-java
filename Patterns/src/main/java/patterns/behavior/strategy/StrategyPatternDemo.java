package patterns.behavior.strategy;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
 * 
 * from: http://sourcemaking.com/design_patterns/strategy
 * 
 * One of the dominant strategies of object-oriented design is 
 * the "open-closed principle".
 * 
 */
public class StrategyPatternDemo {
	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationSubstract());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new Context(new OperationMultiply());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}
}