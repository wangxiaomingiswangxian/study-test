package study.jdk.record;

import study.mybatis.dataobject.UserDO;

public record StudyRecord(UserDO u) {

    public StudyRecord{
        u= new UserDO();
    }
    public StudyRecord(){
        this(new UserDO());
    }
}
