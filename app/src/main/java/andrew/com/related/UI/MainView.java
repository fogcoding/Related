package andrew.com.related.UI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.openapi.UsersAPI;
import com.sina.weibo.sdk.openapi.legacy.StatusesAPI;

import java.util.ArrayList;

import andrew.com.related.R;
import andrew.com.related.adapter.RecyclerViewAdapter;
import andrew.com.related.toolClass.AccessTokenKeeper;
import andrew.com.related.toolClass.Constants;
import andrew.com.related.toolClass.CustomWeibo;
import andrew.com.related.toolClass.DividerItemDecoration;
import andrew.com.related.toolClass.JsonParesingTool;

public class MainView extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Handler handler;
    private Oauth2AccessToken mAccessToken;
    private UsersAPI mUsersAPI;
    private StatusesAPI statusesAPI;
    private String StorageResponse; //用于临时保存微博返回的数据
    private ArrayList<CustomWeibo> CustomWeibos;      //用于存放解析后的微博信息
    private RecyclerView rv;
    private JsonParesingTool tool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);

        // 获取当前已保存过的 Token
        mAccessToken = AccessTokenKeeper.readAccessToken(this);
        mUsersAPI = new UsersAPI(MainView.this, Constants.APP_KEY,mAccessToken); // 获取用户信息接口
        statusesAPI = new StatusesAPI(MainView.this,Constants.APP_KEY,mAccessToken); //创建微博分享接口实例
        StorageResponse = new String();     //用于储存返回数据的字符串容器
        CustomWeibos = new ArrayList<CustomWeibo>();

        //初始化handler，设置UI更新
        rv = (RecyclerView) findViewById(R.id.weibo_list);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0){
                    ArrayList<CustomWeibo> temp = (ArrayList<CustomWeibo>) msg.obj;
                    //为主界面的微博信息设置适配器
                    rv.setLayoutManager(new LinearLayoutManager(MainView.this));
                    rv.addItemDecoration(new DividerItemDecoration(MainView.this,DividerItemDecoration.VERTICAL_LIST));
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainView.this,temp);
                    rv.setAdapter(adapter);

                }

            }
        };

        //顶部ActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //左侧菜单
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //绑定左侧菜单列表，设置监听
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //上下滑动查看最新微博
        //TODO 设置数据的动态显示，显示的数据量和滑动的距离有关

        new Thread(new Runnable() {
            @Override
            public void run() {
                statusesAPI.friendsTimeline(0,0,15,1,false,0,false,mListener);
            }
        }).start();



        //实现聊天界面窗口
        findViewById(R.id.btn_Chatting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainView.this,ChattingView.class);
                startActivity(i);
            }
        });


        //TODO 为底部的ActionBar设置拍照，分享，聊天，扫二维码

        //TODO 顶部ActionBar 设置搜索，小游戏

        //TODO 左侧列表的相关功能实现 个人信息设置，消息管理，图库管理，联系人好友，主题切换，保存登陆密码，注销新浪微博信息，特色功能：手电筒，手机锁屏三次解锁失败前置摄像头拍照

        //TODO 编写应用的相关说明文档

        //TODO 进入前显示一张图片三秒






    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i = new Intent(MainView.this,CameraView.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {
            //本地图库

        } else if (id == R.id.nav_ImMenager) {
            //消息管理

        } else if (id == R.id.nav_setting) {
            //应用设置

        } else if (id == R.id.nav_share) {
            //微博分享

        } else if (id == R.id.nav_Communicate) {
            //短信聊天

        }else if (id == R.id.nav_features){
            //特色功能

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private RequestListener mListener = new RequestListener() {
        @Override
        public void onComplete(String response) {
            if (!TextUtils.isEmpty(response)) {
                //获得返回的JSON数据流
                StorageResponse = response;

                if (StorageResponse != null) {
//                    Looper.prepare();
                    Toast.makeText(getApplicationContext(), "返回的数据非空", Toast.LENGTH_SHORT).show();
                    tool = new JsonParesingTool();
                    CustomWeibos = tool.paresing(StorageResponse);              //解析返回的JSON数据流
                    handler.sendMessage(handler.obtainMessage(0, CustomWeibos));
                }else{
                    Toast.makeText(getApplicationContext(), "返回的数据为空", Toast.LENGTH_SHORT).show();
                }
            }
        }

        @Override
        public void onWeiboException (WeiboException e){
            Toast.makeText(MainView.this, "WeiboException", Toast.LENGTH_LONG).show();
        }

    };

    //增加新浪微博的数据
    private ArrayList<CustomWeibo> addData(ArrayList<CustomWeibo> temp){
        ArrayList<CustomWeibo> result = CustomWeibos;
        for (int i = 0; i < CustomWeibos.size();i++){
            temp.add(CustomWeibos.get(i));
        }
        return result;
    }

}
