package study.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.spring.aop.lib.jdkproxy.MyInvocationHandler;
import study.spring.aop.lib.jdkproxy.UserService;
import study.spring.aop.lib.jdkproxy.UserServiceImpl;
import study.spring.bean.properity.DateTest;
import study.spring.event.TestEvent;

public class SpringTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        final DateTest dateTest = (DateTest)applicationContext.getBean("dateTest");
        System.out.println(dateTest);
    }

    @Test
    public void testListener(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        TestEvent event = new TestEvent("hello","msg");
        applicationContext.publishEvent(event);
    }

    @Test
    public void testProxy(){
        UserService userService = new UserServiceImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);
        UserService proxy = (UserService)myInvocationHandler.getProxy();
        proxy.add();
    }
}