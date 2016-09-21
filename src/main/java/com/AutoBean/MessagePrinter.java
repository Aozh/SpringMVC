package com.AutoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoli8 on 2016/9/20.
 */
@Component
public class MessagePrinter {
    @Autowired
    private MessageService messageService;
//两个注解方法都管用
//    @Autowired
//    public void setMessageService(MessageService messageService) {
//        this.messageService = messageService;
//    }

    public void printMessage(String user) {
        System.out.println(String.format(messageService.getMessage(), user));
    }
}
