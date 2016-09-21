package com.AOPProxy;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
public class GreetHello implements Greet {
    @Override
    public void say(String name) {
//        before();
        System.out.println("Hello! " + name);
//        after();
    }

//    private void after() {System.out.println("Before");
//    }
//
//    private void before() {System.out.println("After");
//    }
}
