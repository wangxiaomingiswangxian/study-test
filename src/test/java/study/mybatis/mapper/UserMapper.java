package study.mybatis.mapper;

import study.mybatis.dataobject.UserDO;

public interface UserMapper {

    void insertUser(UserDO userDO);

    UserDO getOne(Integer userId);
}
