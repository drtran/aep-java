package patterns.creation.singleton;

public class FileLogger implements Logger {

	private static FileLogger fileLogger;
	
	private FileLogger() {
	
	}
	
	public static FileLogger getFileLogger() {
		if (fileLogger == null) {
			fileLogger = new FileLogger();
		}
		return fileLogger;
	}
	
	public synchronized void log(String msg) {
		System.out.println("toFile: "+msg);
	}

}
