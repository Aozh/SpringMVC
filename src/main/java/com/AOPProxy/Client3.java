package com.AOPProxy;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
public class Client3
{
    public static void main(String[] args) {
        Greet greeting = CGLibDynamicProxy.getInstance().getProxy(GreetHello.class);
        greeting.say("Jack");
    }
}
