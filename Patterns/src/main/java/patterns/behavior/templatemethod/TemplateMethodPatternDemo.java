package patterns.behavior.templatemethod;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/template_pattern.htm
 * 
 * src: http://sourcemaking.com/design_patterns/template_method
 * 
 * Two different components have significant similarities, but demonstrate 
 * no reuse of common interface or implementation. If a change common to 
 * both components becomes necessary, duplicate effort must be expended.
 * 
 */
public class TemplateMethodPatternDemo {
	public static void main(String[] args) {

		Game game = new Cricket();
		game.play();
		System.out.println();
		game = new Football();
		game.play();
	}
}
