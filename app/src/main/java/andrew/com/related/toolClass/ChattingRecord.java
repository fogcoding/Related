package andrew.com.related.toolClass;

import java.util.ArrayList;

/**
 * 用于记录聊天信息的类
 * Created by Andrew on 2016/8/1.
 */
public class ChattingRecord {
    //查询的字符串
    //命名规则：取两个用户的昵称组成该字符串，Self在前
    private final String SelfAndFrom;
    private ArrayList<SingleRecord> RecordContainer;

    //TODO 将此记录存放在数据库和网络中

    public ChattingRecord(SingleRecord singleRecord) {
        this.RecordContainer = new ArrayList<SingleRecord>();
        this.RecordContainer.add(singleRecord);
        RelatedUser self = this.RecordContainer.get(0).getUser();
        RelatedUser fromOther = this.RecordContainer.get(0).getAimUser();
        String name = self.getRelatedName()+fromOther.getRelatedName();
        this.SelfAndFrom = name;
    }

    //增加聊天记录
    public boolean ChattingRecordInsert(SingleRecord singleRecord){
        int i = this.RecordContainer.size();
        this.RecordContainer.add(singleRecord);
        if (this.RecordContainer.size()>i){
            return true;
        }
        return false;
    }

    //清空聊天记录
    public boolean emptyChatingRecord(){
        this.RecordContainer = null;
        if (this.RecordContainer.size()>0){
            return false;
        }
        return true;
    }
}
