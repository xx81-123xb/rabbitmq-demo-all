package com.dupenghao.rabbitmq_spring_producer;

import com.dupenghao.rabbitmq_spring_producer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqSpringProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("pingguo001", "dph001", 5);
        orderService.makeOrder("pingguo002", "dph001", 5);
        orderService.makeOrder("pingguo003", "dph001", 5);

        orderService.makeOrderDirect("pingguo001", "dph001", 5,"sms");
        orderService.makeOrderDirect("pingguo002", "dph001", 5,"wechat");
//        orderService.makeOrderDirect("pingguo003", "dph001", 5,"email");

    }

}
