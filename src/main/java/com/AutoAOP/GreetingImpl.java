package com.AutoAOP;

import org.springframework.stereotype.Component;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
@Component
public class GreetingImpl implements Greeting {

    @Override
    public void sayHello(String name) {
//        before();
        System.out.println("Hello! " + name);
//        after();
    }

    private void before() {
//        System.out.println("Before");
    }

    private void after() {
//        System.out.println("After");
    }
}