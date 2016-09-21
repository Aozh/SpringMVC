package com.AOPProxy;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
public class Client1 {
    public static void main(String[] args) {
        Greet greetingProxy = new GreetingProxy(new GreetHello());
        greetingProxy.say("Jack");
    }
}
