package com.dupenghao.rabbitmq_spring_consumer.service.fanout;

import com.dupenghao.common.OrderInfo;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by 杜鹏豪 on 2023/6/7.
 */
@RabbitListener(queues = {"sms.fanout.queue"})
@Component
public class SmsConsumer {

    @RabbitHandler
    public void receiveMessage(Object message) {
        System.out.println("Sms fanout -- 接收到了订单信息是:->" + message);
    }

}
