package andrew.com.related.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import andrew.com.related.R;
import andrew.com.related.toolClass.ChattingRecord;

/**
 * Created by Andrew on 2016/8/1.
 */
public class ChattingAdapter extends RecyclerView.Adapter {
    //聊天信息记录
    private ChattingRecord adapterChattingRecord;
    //聊天记录的名字
    private String ChattingRecordName;
    //TODO 添加聊天记录的属性和相关适配

    public ChattingAdapter() {

    }

    //用于容纳聊天记录的ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_friend_iamge;           //朋友的用户头像
        public ImageView iv_self_iamge;             //自己的用户头像
        public TextView tv_send_by_friend;          //朋友发送的信息
        public TextView tv_send_by_self;            //自己发送的信息

        public ViewHolder(View itemView) {
            super(itemView);
            this.iv_friend_iamge = (ImageView) itemView.findViewById(R.id.iv_friend_iamge);
            this.iv_self_iamge = (ImageView) itemView.findViewById(R.id.iv_self_iamge);
            this.tv_send_by_friend = (TextView) itemView.findViewById(R.id.tv_send_by_friend);
            this.tv_send_by_self = (TextView) itemView.findViewById(R.id.tv_send_by_self);

        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatting_view,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
