package study.rmi;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.rmi.client.HelloRMIService;

public class ClientTest {
    @Test
    public void test(){
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("rmi/RMIClient.xml");
        HelloRMIService hms = context.getBean("myClient",HelloRMIService.class);
        System.out.println(hms.getAdd(1,2));
    }
}
