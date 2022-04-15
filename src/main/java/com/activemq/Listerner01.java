package com.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 订阅者01监听器
 */
public class Listerner01 implements MessageListener{


    @Override
    public void onMessage(Message message) {
        try{
            System.out.println("订阅到01的消息"+((TextMessage)message).getText());
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
