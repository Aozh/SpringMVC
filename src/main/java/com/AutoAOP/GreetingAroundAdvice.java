package com.AutoAOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }
}
