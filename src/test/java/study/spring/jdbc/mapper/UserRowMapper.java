package study.spring.jdbc.mapper;
import org.springframework.jdbc.core.RowMapper;
import study.spring.jdbc.dataobject.UserDO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDO userDO = new UserDO();
        userDO.setId(rs.getInt("id"));
        userDO.setCreatorName(rs.getString("creator_name"));
        return userDO;
    }
}
