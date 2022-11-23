package study.spring.jdbc.service;

import study.spring.jdbc.dataobject.UserDO;

import java.util.List;

public interface UserService {

    List<UserDO> getUsers();
}
