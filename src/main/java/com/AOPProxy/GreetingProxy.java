package com.AOPProxy;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
public class GreetingProxy implements Greet {

    private GreetHello greetHello;

    public GreetingProxy(GreetHello greetingImpl) {
        this.greetHello = greetingImpl;
    }

    @Override
    public void say(String name) {
        before();
        greetHello.say(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}