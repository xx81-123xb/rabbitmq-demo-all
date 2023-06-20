package com.dupenghao.rabbitmq_spring_consumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by 杜鹏豪 on 2023/6/7.
 */
@RabbitListener(queues = {"${wechat}"})
@Component
public class WechatDirectConsumer {

    @RabbitHandler
    public void receiveMessage(Object message) {
        System.out.println("Wechat direct -- 接收到了订单信息是:->" + message);
    }

}
