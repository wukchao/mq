package com.kc.mq.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */

@Component
public class TopicConsumer {

    /**
     * * 表示一个
     * # 表示 零个或多个
     * @param message
     */

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,exchange = @Exchange(name = "topics",type = "topic"),key = {"user.save","user.*"})
    })
    public void receiver(String message){
        System.out.println("topic message=2" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,exchange = @Exchange(name = "topics",type = "topic"),key = {"order.#","produce.#","user.*"})
    })
    public void receiver2(String message){
        System.out.println("topic message2=" + message);
    }
}
