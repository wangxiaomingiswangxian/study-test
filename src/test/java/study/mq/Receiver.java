package study.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

public class Receiver {

    @Test
    public void test() throws JMSException {
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        Connection connection = activeMQConnectionFactory.createConnection();
        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createQueue("my-queue");
        MessageConsumer consumer = session.createConsumer(destination);

        int i =0;
        while (i<3){
            i++;
            TextMessage textMessage = (TextMessage)consumer.receive();
            session.commit();
            System.out.println(textMessage.getText());
        }
        session.close();
        connection.close();
    }
}
