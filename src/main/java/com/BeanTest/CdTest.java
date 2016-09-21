package com.BeanTest;

/**
 * Created by zhaoli8 on 2016/9/19.
 * 最初bean自动装配测试
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Cdconfig.class)
@Component
public class CdTest {
//    ApplicationContext cont=new FileSystemXmlApplicationContext("src/CdTest-context.xml");
    @Autowired
    private CompactDis co;
//    CompactDis co=cont.getBean("sgtP",CompactDis.class);
    @Test
//    public void cdNot(){
//        assertNotNull(co);
//    }
    public void cdNotNull(){
        if(co==null)
            System.out.println("null");
        else
            System.out.println("not null");
    }
    public void loud(){
        System.out.println("hah");
    }
}
