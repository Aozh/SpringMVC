package com.JavaConfig;

/**
 * Created by zhaoli8 on 2016/9/20.
 */
public class MessImp implements Mess{
    @Override
    public String getmes() {
        return "Hello, %s ";
    }
}
