package com.kc.mq.test;

import com.kc.mq.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestRabbitMq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // topic

    @Test
    public void testTopic() {
        
        rabbitTemplate.convertAndSend("topics","user.save","发布和订阅消息");
    }


    // route 路由
    @Test
    public void testRoute(){
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend("direct","error","send error level infomation");
            rabbitTemplate.convertAndSend("direct","info","send info level infomation");
        }
    }

    // route 路由
    @Test
    public void testRoute1(){
        rabbitTemplate.convertAndSend("direct","error","send error level infomation");
    }

    // fanout 广播
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","我在广播土巴兔信息");
    }

    // 工作队列
    @Test
    public void testWorkQueue(){
        for (int i = 0; i < 15; i++) {
            rabbitTemplate.convertAndSend("work","work template"+i);
        }
    }

    // hello world
    @Test
    public void testHelloWorld(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }
}
