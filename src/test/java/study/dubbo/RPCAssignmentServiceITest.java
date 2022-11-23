package study.dubbo;

import cn.clothmate.developer.api.rpc.RPCAssignmentServiceI;
import cn.clothmate.developer.dto.AssignmentListByNameQry;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.junit.jupiter.api.Test;

/**
 * @author lu.yue on 2022/6/30
 */
public class RPCAssignmentServiceITest {

    @Test
    public void testGetOneselfAssignment()  {

        AssignmentListByNameQry assignmentListByNameQry = new AssignmentListByNameQry();
        assignmentListByNameQry.setDeveloperId(1);
        ApplicationModel.defaultModel().getApplicationConfigManager().setApplication(new ApplicationConfig("ConsumerTest"));
        final RPCAssignmentServiceI rpcAssignmentServiceI =
                DubboRemoteServiceBuilder.client(RPCAssignmentServiceI.class).baseUrl("dubbo://192.168.32.243:28002/").build();
        System.out.println(rpcAssignmentServiceI.getOneselfAssignment(assignmentListByNameQry));
    }
}
