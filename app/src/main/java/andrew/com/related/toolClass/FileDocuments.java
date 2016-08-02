package andrew.com.related.toolClass;

import android.os.Environment;

import java.io.File;

/**
 * Created by Andrew on 2016/7/31.
 */
public class FileDocuments {
    //手机内存卡根目录
    public static final File PARENT_DOCUMENT = Environment.getExternalStorageDirectory();
    //图库目录
    public static final File GALLERY_DOCUMENT = new File(Environment.getExternalStorageDirectory() + File.separator + "Related" + File.separator + "Gallery");
    //聊天记录
    public static final File CHATTING_DOCUMENT = new File(Environment.getExternalStorageDirectory() + File.separator + "Related" + File.separator + "CHATTING");
    //登陆记录
    public static final File LOGIN_DOCUMENT = new File(Environment.getExternalStorageDirectory() + File.separator + "Related" + File.separator + "LOGIN");
    //关于相机
    public static final File GUIDE_DOCUMENT = new File(Environment.getExternalStorageDirectory() + File.separator + "Related" + File.separator + "GUIDE");
    //错误日志
    public static final File LOG_DOCUMENT = new File(Environment.getExternalStorageDirectory() + File.separator + "Related" + File.separator + "LOG");

    public static void CreateFile() {

        if (!GALLERY_DOCUMENT.mkdirs()&&!GALLERY_DOCUMENT.exists()) {
            LogDairy.writeLog("Gallery 创建失败");
        }
        if (!CHATTING_DOCUMENT.mkdirs()&&!CHATTING_DOCUMENT.exists()) {
            LogDairy.writeLog("CHATTING 创建失败");
        }
        if (!LOGIN_DOCUMENT.mkdirs() && !LOGIN_DOCUMENT.exists()) {
            LogDairy.writeLog("login 创建失败");
        }
        if (!GUIDE_DOCUMENT.mkdirs()&&!GUIDE_DOCUMENT.exists()) {
            LogDairy.writeLog("Guide 创建失败");
        }
        if (!LOG_DOCUMENT.exists()){
            LOG_DOCUMENT.mkdirs();
        }

    }
}
