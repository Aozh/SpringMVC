package com.XmlBeanTest;

/**
 * Created by zhaoli8 on 2016/9/20.
 */
public class Chinese implements People {

    private Food food;
    private String name;


    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void loud() {
        System.out.println("呵呵"+"  "+food.color()+"    姓名   "+name);
    }
}
