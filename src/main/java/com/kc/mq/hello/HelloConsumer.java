package com.kc.mq.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "true"))
public class HelloConsumer {

    @RabbitHandler
    public void receiver(String message){
        System.out.println("message=" + message);
    }
}
