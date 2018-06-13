package Model;

public class LoggerActions extends Logger{
    private static LoggerActions logger;

    private LoggerActions(){}

    public static LoggerActions getInstance(){
        if(logger == null)
            logger = new LoggerActions();
        return logger;
    }
}
