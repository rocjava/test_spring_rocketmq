package com.penn.springrocketmq.controller;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import com.penn.springrocketmq.Constant.Constants;
import com.penn.springrocketmq.mq.RocketMQProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RocketMqController {

    final Logger logger = Logger.getLogger(RocketMqController.class);

    @Resource
    @Qualifier("rocketMQProducer")
    private RocketMQProducer rocketMQProducer;

    @RequestMapping("/sendMq")
    public String index() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "现在的时间是:"+ format.format(new Date());
        Message msg = new Message(Constants.MQ_TOPIC,Constants.MQ_TAG,str.getBytes());
        SendResult result = rocketMQProducer.getDefaultMQProducer().send(msg);
        logger.info(Thread.currentThread().getName()+ "---->发送1条消息"+ result);

        return "index";
    }
}
