package com.BeanTest;

import org.springframework.stereotype.Component;

/**
 * Created by zhaoli8 on 2016/9/19.
 */
@Component
public class SgtP implements CompactDis{

    private String title="Club";
    private String atrist="Beatles";
    @Override
    public void play() {
        System.out.println(title+"演唱"+atrist);
    }

}
