package com.study.thread;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author 王贤
 */
public class Sender {

    public static void main(String[] args) throws JMSException, InterruptedException {
        ConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        Connection connection = activeMQConnectionFactory.createConnection();
        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        Destination destination=session.createQueue("my-queue");
        MessageProducer producer = session.createProducer(destination);
        for (int i = 0; i < 3; i++) {
            TextMessage message= session.createTextMessage("这是一个测试");
            System.out.printf("send%d",i);
            Thread.sleep(10000);
            producer.send(message);
        }
        session.commit();
        session.close();
        connection.close();
    }
}
