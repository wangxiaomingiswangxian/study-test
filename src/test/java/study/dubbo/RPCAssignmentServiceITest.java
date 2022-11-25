package study.dubbo;

import cn.clothmate.developer.api.rpc.RPCAssignmentServiceI;
import cn.clothmate.developer.dto.AssignmentListByNameQry;
import cn.clothmate.developer.dto.clientobject.AssignmentDTO;
import cn.clothmate.upms.dto.clientobject.ProductLineDTO;
import cn.clothmate.upms.rpc.ProductLineRemoteService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.rpc.model.ApplicationModel;
import org.junit.jupiter.api.Test;

import java.util.List;

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
                DubboRemoteServiceBuilder.client(RPCAssignmentServiceI.class).baseUrl("dubbo://192.168.32.166:28002/").build();
        final com.cloth.mate.mesh.dto.PageResponse<AssignmentDTO> oneselfAssignment = rpcAssignmentServiceI.getOneselfAssignment(assignmentListByNameQry);
        System.out.println(oneselfAssignment);
    }

    @Test
    public void testRemoteClothUserService()  {
        final ApplicationConfig consumerTest = new ApplicationConfig("ConsumerTest");
        consumerTest.setVersion("1.0.0");
        ApplicationModel.defaultModel().getApplicationConfigManager().setApplication(consumerTest);
        final ProductLineRemoteService  productLineRemoteService =
                DubboRemoteServiceBuilder.client(ProductLineRemoteService.class).baseUrl("dubbo://192.168.32.11:20880/").serviceName("providers:cn.clothmate.upms.rpc.ProductLineRemoteService:1.0.0:dubbo").build();
        final List<ProductLineDTO> productLineDTOS = productLineRemoteService.queryListProductLint(1);
    }
}
