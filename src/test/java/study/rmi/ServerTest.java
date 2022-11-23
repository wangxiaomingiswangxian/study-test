package study.rmi;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerTest {
    @Test
    public void test(){

    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("rmi/RMIServer.xml");
    }
}
