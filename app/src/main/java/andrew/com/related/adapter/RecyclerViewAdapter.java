package andrew.com.related.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import andrew.com.related.R;
import andrew.com.related.toolClass.AsyncTaskImageLoad;
import andrew.com.related.toolClass.CustomWeibo;

/**
 * Created by Andrew on 2016/7/30.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<CustomWeibo> customWeibos;
    private int CurrentPosition;

    public RecyclerViewAdapter(Context context,ArrayList<CustomWeibo> customWeibos){
        this.context = context;
        this.customWeibos = customWeibos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.attrs_layout,null);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder root = (ViewHolder) holder;

        //设置数据显示
        new AsyncTaskImageLoad(root.imb_head).execute(customWeibos.get(position).getUser().profile_image_url);  //用户头像
        root.tv_weibo_username.setText(customWeibos.get(position).getUser().name);
        root.tv_time_and_phone.setText(customWeibos.get(position).getUser().idstr);
        root.tv_weibo_text.setText(customWeibos.get(position).getText());
//        root.tv_user_comments.setText(customWeibos.get(position).getCommented_user().idstr);
//        root.tv_weibo_by_commented.setText(customWeibos.get(position).getCommented_text());

        CurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return customWeibos.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageButton imb_head;               //用户的微博头像
        public TextView tv_weibo_username;        //用户的昵称
        public TextView tv_time_and_phone;         //微博发送时间和来源类型
        public TextView tv_weibo_text;             //微博正文
        public ImageView iv_weibo_image_text;      //微博正文的图片

        public TextView tv_user_comments;          //被评论的用户
        public TextView tv_weibo_by_commented;     //用户评论的微博正文
        public ImageView iv_weibo_by_commented;       //用户评论的微博图片

        private Button btn_reported_count;          //转发数
        private Button btn_comments_count;          //评论数
        private Button btn_attitudes_count;         //点赞数

        public ViewHolder(View itemView) {
            super(itemView);

            this.imb_head = (ImageButton) itemView.findViewById(R.id.imb_head);
            this.tv_weibo_username = (TextView) itemView.findViewById(R.id.tv_weibo_username);
            this.tv_time_and_phone = (TextView) itemView.findViewById(R.id.tv_time_and_phone);
            this.tv_weibo_text = (TextView) itemView.findViewById(R.id.tv_weibo_text);
            this.iv_weibo_image_text = (ImageView) itemView.findViewById(R.id.iv_weibo_image_text);
            this.tv_user_comments = (TextView) itemView.findViewById(R.id.tv_user_comments);
            this.tv_weibo_by_commented = (TextView) itemView.findViewById(R.id.tv_weibo_by_commented);
            this.iv_weibo_by_commented = (ImageView) itemView.findViewById(R.id.iv_weibo_by_commented);
            this.btn_reported_count = (Button) itemView.findViewById(R.id.btn_reported_count);
            this.btn_comments_count = (Button) itemView.findViewById(R.id.btn_comments_count);
            this.btn_attitudes_count = (Button) itemView.findViewById(R.id.btn_attitudes_count);

        }

    }


    public int getCurrentPosition() {
        return CurrentPosition;
    }
}
