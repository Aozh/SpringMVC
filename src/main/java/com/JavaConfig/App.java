package com.JavaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by zhaoli8 on 2016/9/20.
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
        MessagePrinter mess = context.getBean(MessagePrinter.class);
        messagePrinter.printMess("xiaoming");
//         注释的是早期没有接口的
//        messagePrinter.printMessage("xiaoming");

        System.out.println();

    }
}
