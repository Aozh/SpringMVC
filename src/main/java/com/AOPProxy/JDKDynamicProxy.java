package com.AOPProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhaoli8 on 2016/9/21.
 */
public class JDKDynamicProxy implements InvocationHandler {
   private GreetHello greetHello;
    public JDKDynamicProxy(GreetHello g){
        this.greetHello=g;
    }
   @SuppressWarnings("unchecked")
   public <T>T getPro(){
       return (T) Proxy.newProxyInstance
               (greetHello.getClass().getClassLoader(),
               greetHello.getClass().getInterfaces(),this
               );
   }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        //反射得到
        Object result = method.invoke(greetHello, args);
        after();
        return result;
    }
    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
