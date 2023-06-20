package com.dupenghao.rabbitmq_spring_consumer;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RabbitmqSpringConsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RabbitmqSpringConsumerApplication.class, args);

//        Queue queue = context.getBean(Queue.class);
//        System.out.println(queue.getName());
//        context.getBeansOfType(Queue.class).forEach((k, v) -> System.out.println(k + " : " + v.getName()));

    }

}
