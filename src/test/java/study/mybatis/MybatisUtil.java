package study.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class MybatisUtil {
    private final static SqlSessionFactory sqlSessionFactory;
    public static final ThreadLocal<SqlSession> sessionThread = new ThreadLocal<>();
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config-test.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static SqlSession getSqlSessionFactory() {
        SqlSession sqlSession = sessionThread.get();
        if (Objects.isNull(sqlSession)) {
            sqlSession = sqlSessionFactory.openSession();
            sessionThread.set(sqlSession);
        }
        return sqlSession;
    }
}
