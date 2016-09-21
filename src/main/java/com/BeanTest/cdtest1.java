package com.BeanTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.Assert.assertNotNull;

/**
 * Created by zhaoli8 on 2016/9/20.
 */
@ComponentScan
public class cdtest1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(cdtest1.class);
        CdTest cd = context.getBean(CdTest.class);
        assertNotNull(cd);
        cd.loud();
    }
}
