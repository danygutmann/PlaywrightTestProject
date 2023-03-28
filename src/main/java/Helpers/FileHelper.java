package Helpers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHelper
{
    public static String GetFilenameWithTimestamp(String workingDirectory, String fileNamePostFix) {
        StringBuffer fn = new StringBuffer();
        fn.append(workingDirectory);
        fn.append("/");
        fn.append("-");
        DateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
        fn.append(df.format(new Date()));
        fn.append(fileNamePostFix);
        return fn.toString();

    }
    public static Path GetUserDirectoryPath(){
        return Paths.get("").toAbsolutePath();
    }
    public static Path GetFilePathFromString(String filepath){
        return Path.of(filepath);
    }

}
