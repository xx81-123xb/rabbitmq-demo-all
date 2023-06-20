package com.dupenghao.rabbitmq_spring_consumer.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by 杜鹏豪 on 2023/6/7.
 */
@RabbitListener(bindings = @QueueBinding(
        value=@Queue(name = "sms.topic.queue",durable = "true",autoDelete = "false"),
        exchange = @Exchange(name = "topic_order_exchange",type = ExchangeTypes.TOPIC),
        key = "#.sms.#"
))
@Component
public class SmsConsumer {

    @RabbitHandler
    public void receiveMessage(Object message) {
        System.out.println("Sms topic -- 接收到了订单信息是:->" + message);
    }

}
