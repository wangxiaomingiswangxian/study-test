package study.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import study.mybatis.dataobject.UserDO;
import study.mybatis.mapper.UserMapper;


public class MybatisTest {
    SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void before() {
        sqlSession = MybatisUtil.getSqlSessionFactory();
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @Test
    public void testInsert(){
        final UserDO userDO = new UserDO();
        userDO.setCreatorName("testsestat");
        userMapper.insertUser(userDO);
    }
}
