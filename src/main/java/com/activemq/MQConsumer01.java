package com.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 订阅者模式-01
 */
public class MQConsumer01 {
    public static void main(String[] args) {
        ConnectionFactory factory;
        Connection connection = null;
        Session session;
        Destination destination;
        try {
            factory = new ActiveMQConnectionFactory(Constants.MQ_NAME, Constants.MQ_PASSWORD, Constants.MQ_BROKERRL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("parryTopic");
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new Listerner01());
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
