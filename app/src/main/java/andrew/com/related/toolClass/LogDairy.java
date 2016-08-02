package andrew.com.related.toolClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrew on 2016/7/31.
 */
public class LogDairy {

    private static String CuurentTime;
    private static File temp;

    public static boolean writeLog(String s){
        CuurentTime = new SimpleDateFormat("yyyymmdd_hhmmss").format(new Date());
        temp = new File(FileDocuments.LOG_DOCUMENT+File.separator+CuurentTime+"log.txt");
        try {
            temp.createNewFile();
            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(s.getBytes(),0,s.getBytes().length);
            fos.flush();
            fos.close();
            if (temp.length()>0){
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
