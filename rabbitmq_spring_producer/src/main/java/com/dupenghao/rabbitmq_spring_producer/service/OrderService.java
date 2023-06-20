package com.dupenghao.rabbitmq_spring_producer.service;

import com.dupenghao.common.OrderInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by 杜鹏豪 on 2023/6/7.
 */
@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(String itemId, String userId, int num) {
        //1.根据商品id查询库存是否充足
        //2.保存订单
        //3.通过MQ来完成消息的分发
        OrderInfo orderInfo = new OrderInfo(itemId, userId, num, userId + "下单了" + num + "件商品");
        ArrayList<OrderInfo> orderInfos = new ArrayList<>();
        orderInfos.add(orderInfo);
        rabbitTemplate.convertAndSend("fanout_order_exchange", "", orderInfos);
    }

    public void makeOrderDirect(String itemId, String userId, int num,String routingKey) {
        //1.根据商品id查询库存是否充足
        //2.保存订单
        //3.通过MQ来完成消息的分发
        OrderInfo orderInfo = new OrderInfo(itemId, userId, num, userId + "下单了" + num + "件商品");
        ArrayList<OrderInfo> orderInfos = new ArrayList<>();
        orderInfos.add(orderInfo);
        rabbitTemplate.convertAndSend("direct_order_exchange", routingKey, orderInfos);
    }

}


