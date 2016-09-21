package com.XmlBeanTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by zhaoli8 on 2016/9/20.
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext cont=new FileSystemXmlApplicationContext("src/bean.xml");
//        ApplicationContext cont = new ClassPathXmlApplicationContext("src/bean.xml");
//        ApplicationContext cont=new ClassPathXmlApplicationContext();
        People p=cont.getBean("chinese",People.class);
        People p1=cont.getBean("jap",People.class);
        p.loud();
        p1.loud();

    }
}
