package andrew.com.related.NativeDataBase;

import android.app.Application;

import static andrew.com.related.toolClass.FileDocuments.CreateFile;

/**
 * Created by Andrew on 2016/7/30.
 */
public class RelatedApplication extends Application {

    //TODO !!!!!CREATE NATIVE DATABASE ADN FILE

    @Override
    public void onCreate() {
        super.onCreate();
        //创建应用的文件夹
        CreateFile();

        //NewIM初始化
//        BmobIM.init(this);
//        注册消息接收器
//        BmobIM.registerDefaultMessageHandler(new RelatedMessageHandler(this));


    }


    //TODO 创建本地数据库，用来保存本地聊天信息，相关设置信息，应用缓存信息等需要优化的数据

    //TODO 建立本地文件，用于储存应用运行信息和照片文件，录音文件等需要很大资源空间的数据

    //TODO 建立Service，让应用后台执行一些必要的操作和信息交互


//    /**
//     * 获取当前运行的进程名
//     * @return
//     */
//    public static String getMyProcessName() {
//        try {
//            File file = new File("/proc/" + android.os.Process.myPid() + "/" + "cmdline");
//            BufferedReader mBufferedReader = new BufferedReader(new FileReader(file));
//            String processName = mBufferedReader.readLine().trim();
//            mBufferedReader.close();
//            return processName;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


}
