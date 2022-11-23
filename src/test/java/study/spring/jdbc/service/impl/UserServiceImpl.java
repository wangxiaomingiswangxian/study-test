package study.spring.jdbc.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import study.spring.jdbc.dataobject.UserDO;
import study.spring.jdbc.mapper.UserRowMapper;
import study.spring.jdbc.service.UserService;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserServiceImpl implements UserService {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserDO> getUsers() {
        return jdbcTemplate.query("select * from users",new UserRowMapper());
    }
    @Override
    public void save(UserDO userDO){
        jdbcTemplate.update("insert into users (id,creator_name) values (?,?)",new Object[]{userDO.getId(),userDO.getCreatorName()},new int[]{Types.INTEGER,Types.VARCHAR});
    }
}
