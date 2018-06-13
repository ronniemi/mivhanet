package Model;

public class LoggerError extends Logger{
    private static LoggerError logger;

    private LoggerError(){}

    public static LoggerError getInstance(){
        if(logger == null)
            logger = new LoggerError();
        return logger;
    }
}

