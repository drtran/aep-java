package patterns.creation.singleton;

public class ConsoleLogger implements Logger{
	public void log(String msg) {
		System.out.println("toConsole:"+msg);
	}
}
