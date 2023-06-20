package com.dupenghao.rabbitmq_spring_consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杜鹏豪 on 2023/6/7.
 */
@Configuration
public class TTLRabitMqConfiguration {

    //1.交换机
    @Bean
    public FanoutExchange ttlFanoutExchange() {
        return new FanoutExchange("fanout_ttl_exchange", true, false);
    }

    //2.队列
    @Bean
    public Queue ttlQueue() {
        Map<String,Object> args=new HashMap<>();
        args.put("x-message-ttl",5000);//设置队列中的消息的过期时间
        Queue queue = new Queue("ttl.fanout.queue", true, false, false,args);
        return queue;
    }

    //3.绑定关系
    @Bean
    public Binding ttlBinding() {
        return BindingBuilder.bind(ttlQueue()).to(ttlFanoutExchange());
    }

}
