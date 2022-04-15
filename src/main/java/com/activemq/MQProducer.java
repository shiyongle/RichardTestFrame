package com.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 订阅消息发送者
 */
public class MQProducer {

    public static void main(String[] args) {

        ConnectionFactory factory;

        Connection connection = null;

        Session session;

        Destination destination;

        try {
            factory = new ActiveMQConnectionFactory(Constants.MQ_NAME, Constants.MQ_PASSWORD, Constants.MQ_BROKERRL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("parryTopic");
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage("hello。新消息");
            producer.send(message);
        }catch (JMSException e){
            e.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                }catch (JMSException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
