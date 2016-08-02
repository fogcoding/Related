package andrew.com.related.toolClass;

import com.sina.weibo.sdk.openapi.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Andrew on 2016/7/31.
 */
public class JsonParesingTool {
    private String JsonString;
    private ArrayList<CustomWeibo> CustomWeibos;
    private CustomWeibo customWeibo;

    public JsonParesingTool() {
        this.JsonString = new String();
        this.CustomWeibos = new ArrayList<CustomWeibo>();
    }


    public ArrayList<CustomWeibo> paresing(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray portBySelf = jsonObject.getJSONArray("statuses");

            JSONObject temp = null;
            CommentedWeibo commented_weibo = null;
            String text = null;
            int count = -1;
            JSONObject usertemp = null;
            User user = null;
            for (int i = 0;i<portBySelf.length();i++){
                customWeibo = new CustomWeibo();
                if ((temp=portBySelf.getJSONObject(i))!=null){
                    //微博正文
                    if ((text = temp.getString("text"))!=null){
                        customWeibo.setText(text);
                    }
                    //发布时间
                    if ((text = temp.getString("created_at"))!=null){
                        customWeibo.setCreated_at(text);
                    }
                    //用户信息
                    if ((usertemp = temp.getJSONObject("user"))!=null){
                        user = User.parse(usertemp);
                        customWeibo.setUser(user);
                        user=null;
                    }
                    //转发数
                    if ((count = temp.getInt("reposts_count"))!=-1){
                        customWeibo.setReports_count(count);
                        count = -1;
                    }
                    //评论数
                    if ((count = temp.getInt("comments_count"))!=-1){
                        customWeibo.setComment_count(count);
                        count = -1;
                    }
                    //点赞数
                    if ((count = temp.getInt("attitudes_count"))!=-1){
                        customWeibo.setAttitudes_count(count);
                        count = -1;
                    }
//                    //用户评论的微博的信息
//                    if ((usertemp = temp.getJSONObject("retweeted_status"))!=null){
//                        commented_weibo = CommentedWeibo.parse(usertemp);
//                        if (commented_weibo!=null){
//                            customWeibo.setCommented_Weibo(commented_weibo);
//                        }
//                        usertemp = null;
//                    }
                }
                //将每条的微博信息添加进入自己建立的集合
                this.CustomWeibos.add(customWeibo);
                customWeibo = null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        writeLog("JsonParesingTool："+this.CustomWeibos.size());

        return this.CustomWeibos;
    }


}
