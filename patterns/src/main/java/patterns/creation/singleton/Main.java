package patterns.creation.singleton;

public class Main {

	public static void main(String[] args) {
		LoggerFactory consoleLoggerFactory = new LoggerFactory("console");
		LoggerFactory fileLoggerFactory = new LoggerFactory("file");
		consoleLoggerFactory.getLogger().log("console message");
		fileLoggerFactory.getLogger().log("file message");
	}

}
