package com.kc.mq.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RouteConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue, //创建临时队列
                    exchange = @Exchange(value = "direct",type = "direct"), //自定义交换机名称和类型
                    key = {"info","error","debug"}
            )
    })
    public void  receiver(String messsage) {
        System.out.println("message1="+ messsage);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue, //创建临时队列
                    exchange = @Exchange(value = "direct",type = "direct"), //自定义交换机名称和类型
                    key = {"error"}
            )
    })
    public void  receiver2(String messsage) {
        System.out.println("message2="+ messsage);
    }
}
