package com.AOPProxy;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
public class Client {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();     // 创建代理工厂
        proxyFactory.setTarget(new GreetHello());         // 射入目标类对象
      //  proxyFactory.addAdvice(new GreetAfterandBefore()); // 添加前置增强
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        Greet greeting = (Greet) proxyFactory.getProxy(); // 从代理工厂中获取代理
        greeting.say("Jack");                              // 调用代理的方法
    }
}
