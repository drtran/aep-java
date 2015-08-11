package patterns.creation.singleton;

public class LoggerFactory {
	
	private String type;
	
	public LoggerFactory(String type) {
		this.type = type;
	}
	
	public Logger getLogger() {
		if (type.equals("file")) {
			return FileLogger.getFileLogger();
		} else if (type.equals("console")){
			return new ConsoleLogger();
		}
		return null;
	}
}
