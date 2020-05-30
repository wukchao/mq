package com.kc.mq.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiver1(String message) {
        System.out.println("receiver1="+ message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiver2(String message) {
        System.out.println("receiver2="+ message);
    }
}
