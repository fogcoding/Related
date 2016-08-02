package andrew.com.related.toolClass;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Andrew on 2016/8/1.
 */
public class CommentedWeibo {
    //被评论的微博的正文
    public String Commented_text;
    //被评论微博的博主
    public JSONObject Commented_user;
    //被评论的微博的图片URL
    public String Commented_text_iamge_url;

    public static CommentedWeibo parse(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return CommentedWeibo.parse(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static CommentedWeibo parse(JSONObject jsonObject) {
        if (null == jsonObject) {
            return null;
        }

        CommentedWeibo commentedWeibo = new CommentedWeibo();
        commentedWeibo.Commented_text                 = jsonObject.optString("text", "");
        commentedWeibo.Commented_user                 = jsonObject.optJSONObject("user");
        commentedWeibo.Commented_text_iamge_url           = jsonObject.optString("pic_urls", "");

        return commentedWeibo;
    }


}
