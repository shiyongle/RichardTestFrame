package com.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 点对点模型-消息生产者
 */
public class MSProduct {

    public static void main(String[] args) {

        //连接工厂
        ConnectionFactory factory;

        //连接实例
        Connection connection = null;

        //收发线程实例
        Session session;

        //消息发送目标地址
        Destination destination;

        //消息创建者
        MessageProducer messageProducer;

        try{
            factory = new ActiveMQConnectionFactory(Constants.MQ_NAME, Constants.MQ_PASSWORD, Constants.MQ_BROKERRL);
            //获取连接实例
            connection = factory.createConnection();
            //启动链接
            connection.start();
            //创建接收或发送的线程实例
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //创建队列
            destination= session.createQueue("parryQuene");
            //创建消息生产者
            messageProducer = session.createProducer(destination);
           //创建消息实体，并发送
            TextMessage message = session.createTextMessage("hello, richard");
            messageProducer.send(message);
            session.commit();
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
