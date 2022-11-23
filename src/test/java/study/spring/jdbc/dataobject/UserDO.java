package study.spring.jdbc.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

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
}
