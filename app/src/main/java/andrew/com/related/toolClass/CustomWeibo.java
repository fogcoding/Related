package andrew.com.related.toolClass;

import com.sina.weibo.sdk.openapi.models.User;

/**
 * Created by Andrew on 2016/7/18.
 */
public class CustomWeibo {

    //图片的URL数组
    private String pic_urls;
    //微博正文
    private String text;
    //微博发送时间
    private String created_at;
    //用户信息
    private User user;
    //转发数
    private int reports_count;
    //评论数
    private int comment_count;
    //点赞数
    private int attitudes_count;

    //被评论的微博用户昵称
    private CommentedWeibo commented_Weibo;

    public CommentedWeibo getCommented_Weibo() {
        return commented_Weibo;
    }

    public void setCommented_Weibo(CommentedWeibo commented_Weibo) {
        this.commented_Weibo = commented_Weibo;
    }

    public int getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(int attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public String getPic_urls() {
        return pic_urls;
    }

    public void setPic_urls(String pic_urls) {
        this.pic_urls = pic_urls;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getReports_count() {
        return reports_count;
    }

    public void setReports_count(int reports_count) {
        this.reports_count = reports_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public CustomWeibo(){

    }


}
