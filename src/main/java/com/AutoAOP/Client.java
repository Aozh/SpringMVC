package com.AutoAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
public class Client {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("src/bean.xml"); // 获取 Spring Context
        ApplicationContext context=new FileSystemXmlApplicationContext("src/bean.xml");
        Greeting greeting = (Greeting) context.getBean("greetingProxy");                        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        greeting.sayHello("Jack");                                                              // 调用代理的方法
    }
}

