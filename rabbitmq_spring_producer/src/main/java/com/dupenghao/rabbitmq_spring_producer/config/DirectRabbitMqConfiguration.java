package com.dupenghao.rabbitmq_spring_producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 杜鹏豪 on 2023/6/7.
 */
@Configuration
public class DirectRabbitMqConfiguration {

    //1.交换机
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("direct_order_exchange", true, false);
    }

    //2.队列
    @Bean
    public Queue smsDirectQueue() {
        return new Queue("sms.direct.queue", true);
    }

    @Bean
    public Queue emailDirectQueue() {
        return new Queue("email.direct.queue", true);
    }

    @Bean
    public Queue wechatDirectQueue() {
        return new Queue("wechat.direct.queue", true);
    }

    //3.绑定关系

    @Bean
    public Binding smsDirectBinding() {
        return BindingBuilder.bind(smsDirectQueue()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding emailDirectBinding() {
        return BindingBuilder.bind(emailDirectQueue()).to(directExchange()).with("email");
    }

    @Bean
    public Binding wechatDirectBinding() {
        return BindingBuilder.bind(wechatDirectQueue()).to(directExchange()).with("wechat");
    }

}
