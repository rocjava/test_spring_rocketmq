package com.penn.springrocketmq.controller;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.penn.springrocketmq.mq.RocketMQProducer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RocketMqController {

    @Resource
    @Qualifier("rocketMQProducer")
    private RocketMQProducer rocketMQProducer;

    @RequestMapping("/sendMq")
    public String index() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Message msg = new Message("TestTopic1", "TAG1", ("Time is "+ format.format(new Date())).getBytes());
        SendResult result = rocketMQProducer.getDefaultMQProducer().send(msg);
        System.out.println(result);

        return "index";
    }
}
