package app;

public class Logger {
    private final static String ERROR = "ERROR: ";
    private final static String WARNING = "WARNING: ";
    private final static String INFO = "INFO: ";
    private final static String DB = "DB: ";

    private final static String ANSI_RED = "\u001B[31m";
    private final static String ANSI_BLUE = "\u001B[34m";
    private final static String ANSI_YELLOW = "\u001B[33m";
    private final static String ANSI_RESET = "\u001B[0m";
    private final static String ANSI_CYAN = "\u001B[36m";

    public static String error(String msg, Object obj) {
        String message = ANSI_RED + ERROR + ANSI_RESET + msg;
        return log(message, obj);
    }

    public static String warning(String msg, Object obj) {
        String message = ANSI_YELLOW + WARNING + ANSI_RESET + msg;
        return log(message, obj);
    }

    public static String info(String msg, Object obj) {
        String message = ANSI_BLUE + INFO + ANSI_RESET + msg;
        return log(message, obj);
    }

    public static String db(String msg, Object obj) {
        String message = ANSI_CYAN + DB + ANSI_RESET + msg;
        return log(message, obj);
    }

    public static String error(String msg) {
        return error(msg, null);
    }

    public static String warning(String msg) {
        return warning(msg, null);
    }

    public static String info(String msg) {
        return info(msg, null);
    }

    public static String db(String msg) {
        return db(msg, null);
    }

    private static String log(String msg, Object obj) {

        if (obj != null) {
            String finalMsg = msg + ": " + obj.toString();
            System.out.println(finalMsg);
            return finalMsg;
        }

        System.out.println(msg);
        return msg;
    }
}