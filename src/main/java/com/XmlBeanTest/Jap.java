package com.XmlBeanTest;

/**
 * Created by zhaoli8 on 2016/9/20.
 */
public class Jap implements People {
    private Food food1;
//    private String name1;
    public Jap(Food f){
        this.food1=f;
    }
    @Override
    public void loud() {
        System.out.println("日"+"  "+food1.color()+"    姓名   ");
    }
}
