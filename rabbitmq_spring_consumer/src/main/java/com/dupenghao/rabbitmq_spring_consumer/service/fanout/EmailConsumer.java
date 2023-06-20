package com.dupenghao.rabbitmq_spring_consumer.service.fanout;

import com.dupenghao.common.OrderInfo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by 杜鹏豪 on 2023/6/7.
 */
@RabbitListener(queues = {"email.fanout.queue"})
@Component
public class EmailConsumer {

    @RabbitHandler
    public void receiveMessage(Object message) {
        System.out.println(message.getClass());
        if(message instanceof Message){
            byte[] body = ((Message) message).getBody();
            try {
                ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(body));
                Object o = inputStream.readObject();
                System.out.println("Inner: "+o.getClass());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Email fanout -- 接收到了订单信息是:->" + message);
    }

}
