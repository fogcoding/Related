package andrew.com.related.TestFile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import andrew.com.related.BmobDataService.DataType.Person;
import andrew.com.related.R;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class testing extends AppCompatActivity {

    private String objectID;
//    private TextView Show;
//    private EditText get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        objectID = null;

        new Thread(new Runnable() {
            @Override
            public void run() {
                //第一：默认初始化
                Bmob.initialize(testing.this, "2e01419b7a7e80038987c3e2e04fdb3a");
            }
        }).start();

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p2 = new Person();
                p2.setName("lucky");
                p2.setAddress("北京海淀");
                p2.save(new SaveListener<String>() {
                    @Override
                    public void done(String objectId,BmobException e) {
                        if(e==null){
                            objectID = objectId;
                            Toast.makeText(getApplicationContext(),"添加数据成功，返回objectId为："+objectId,Toast.LENGTH_SHORT).show();
                        }else{
                            objectID = objectId;
                            Toast.makeText(getApplicationContext(),"添加数据失败，返回objectId为："+objectId,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person p2 = new Person();
                p2.setObjectId(objectID);
                p2.delete(new UpdateListener() {

                    @Override
                    public void done(BmobException e) {
                        if(e==null){
                            Toast.makeText(getApplicationContext(),"删除数据成功" ,Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"删除数据失败",Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });



    }

}
