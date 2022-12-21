package study.spring.jdbc.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author 王贤
 */
@Data
@TableName(value = "users")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer memberId;
    private Integer companyId;
    private Integer status;
    private Integer departmentId;
    private String post;
    private Date lastLogin;
    private Boolean isAdmin;
    private Integer superiorId;

    @TableField(exist = false)
    private String mobile;

    @TableField(exist = false)
    private List<Integer> userIds;

    @TableField(exist = false)
    private String account;

    private String creatorName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDO userDO = (UserDO) o;
        return Objects.equals(id, userDO.id) && Objects.equals(memberId, userDO.memberId) && Objects.equals(companyId, userDO.companyId) && Objects.equals(status, userDO.status) && Objects.equals(departmentId, userDO.departmentId) && Objects.equals(post, userDO.post) && Objects.equals(lastLogin, userDO.lastLogin) && Objects.equals(isAdmin, userDO.isAdmin) && Objects.equals(superiorId, userDO.superiorId) && Objects.equals(mobile, userDO.mobile) && Objects.equals(userIds, userDO.userIds) && Objects.equals(account, userDO.account) && Objects.equals(creatorName, userDO.creatorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, memberId, companyId, status, departmentId, post, lastLogin, isAdmin, superiorId, mobile, userIds, account, creatorName);
    }
}
