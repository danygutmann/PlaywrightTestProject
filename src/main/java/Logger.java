import java.text.SimpleDateFormat;

public class Logger {
    private static final Logger OBJ = new Logger();
    private Logger() {
        Info("Logger() Init");
    }
    public static Logger getInstance() {
        return OBJ;
    }
    public void Debug(String message){
        Log("Debug",message);
    }
    public void Info(String message){
        Log("Info",message);
    }
    public void Warn(String message){
        Log("Warn",message);
    }
    public void Error(String message){
        Log("Error",message);
    }

    //region privates
    private void Log(String level, String message){
        String CallerClass = Thread.currentThread().getStackTrace()[3].getClassName();
        String CallerMethod = Thread.currentThread().getStackTrace()[3].getMethodName();
        String CallerFile = Thread.currentThread().getStackTrace()[3].getFileName();

        String del = ";";
        String ts = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        System.out.println(ts + del + CallerClass + del + CallerMethod + del + level + del + message);
    }
    // endregion
}