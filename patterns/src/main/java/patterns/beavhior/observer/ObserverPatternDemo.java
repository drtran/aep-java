package patterns.beavhior.observer;

/**
 * 
 * Source: http://www.tutorialspoint.com/design_pattern/observer_pattern.htm
 * 
 * src: http://sourcemaking.com/design_patterns/observer
 * 
 * A large monolithic design does not scale well as new graphing or 
 * monitoring requirements are levied.
 * 
 */
public class ObserverPatternDemo {
	public static void main(String[] args) {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
	}
}