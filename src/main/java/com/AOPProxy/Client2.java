package com.AOPProxy;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
public class Client2 {
    public static void main(String[] args) {
        Greet greetingProxy = new JDKDynamicProxy(new GreetHello()).getPro();
        greetingProxy.say("Jack");
    }
}
