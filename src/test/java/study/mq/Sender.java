package study.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

public class Sender {

    @Test
    public void test() throws JMSException, InterruptedException {
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        Connection connection = activeMQConnectionFactory.createConnection();
        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createQueue("my-queue");
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 3; i++) {
            TextMessage message= session.createTextMessage("这是一个测试");
            System.out.printf("send%d",i);
            Thread.sleep(1000);
            producer.send(message);
        }
        session.commit();
        session.close();
        connection.close();
    }
}
