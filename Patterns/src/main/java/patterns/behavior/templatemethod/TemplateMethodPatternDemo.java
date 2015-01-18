package patterns.behavior.templatemethod;

/**
 * 
 * source: http://www.tutorialspoint.com/design_pattern/template_pattern.htm
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
