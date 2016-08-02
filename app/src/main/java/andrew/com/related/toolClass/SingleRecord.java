package andrew.com.related.toolClass;

/**
 * Created by Andrew on 2016/8/1.
 */
public class SingleRecord {
    //用户头像
    private RelatedUser User;

    //发功的用户对象
    private RelatedUser AimUser;
    //发送的文本
    private String Message;
    //是否自己所发
    private boolean flag;

    public SingleRecord(RelatedUser user,RelatedUser AimUser, String message, boolean flag) {
        this.User = user;
        this.AimUser = AimUser;
        this.Message = message;
        this.flag = flag;
    }

    public RelatedUser getUser() {
        return User;
    }

    public RelatedUser getAimUser() {
        return AimUser;
    }

    public String getMessage() {
        return Message;
    }

    public boolean isFlag() {
        return flag;
    }

}
