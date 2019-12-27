package app.utils;

public class Logger {
	
	public static void log(String message) {
		StackTraceElement element = Thread.currentThread().getStackTrace()[2];
        String className = element.getClassName();
        className = className.substring(className.lastIndexOf(".") + 1, className.length());
        String methodName = element.getMethodName();
        System.out.println("INFO: " + className + " " + methodName + " : " + message);
	}
	
	public static void errorLog(String message) {
		StackTraceElement element = Thread.currentThread().getStackTrace()[2];
        String className = element.getClassName();
        className = className.substring(className.lastIndexOf(".") + 1, className.length());
        String methodName = element.getMethodName();
        System.out.println("ERROR: " + className + " " + methodName + " : " + message);
	}
}
