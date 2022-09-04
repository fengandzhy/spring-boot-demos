package org.frank.microboot.controller;

import org.frank.microboot.common.controller.AbstractBaseAction;
import org.frank.microboot.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 直接基于Rest架构进行处理，省略了@ResponseBody注解
@RequestMapping("/message/*") // 添加父路径
public class MessageAction extends AbstractBaseAction {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageAction.class); // 获取日志对象
    @RequestMapping("echo") // 子路径
    public Object echo(Message message) { // 进行请求参数的接收以及请求内容的回应
        message.setTitle("【ECHO】" + message.getTitle());
        message.setContent("【ECHO】" + message.getContent());
        return message;
    }
}
