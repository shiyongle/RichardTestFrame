package com.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 点对点--消息消费者
 */
public class MQConsumer {

    public static void main(String[] args) {

        //连工厂
        ConnectionFactory connectionFactory;

        //连实例
        Connection connection = null;

        //收发线程实例
        Session session;

        //消息发送目标地址
        Destination destination;


        try {
            //实例化连接工厂
            connectionFactory = new ActiveMQConnectionFactory(Constants.MQ_NAME, Constants.MQ_PASSWORD, Constants.MQ_BROKERRL);
            //获取连接实例
            connection = connectionFactory.createConnection();
            //启动
            connection.start();
            //创建接收或发送线程实例
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            //创建队列
            destination = session.createQueue("parryQueue");
            //创建消费者
            MessageConsumer messageConsumer = session.createConsumer(destination);
            //注册监听
            messageConsumer.setMessageListener(new MQListerner());
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
