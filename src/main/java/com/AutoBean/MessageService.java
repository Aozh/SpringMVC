package com.AutoBean;

import org.springframework.stereotype.Component;

/**
 * Created by zhaoli8 on 2016/9/20.
 */
@Component
public class MessageService {
    private String message = "Hello, %s!";

    public String getMessage() {
        return message;
    }
}
