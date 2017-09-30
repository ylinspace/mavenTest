package org.cute.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yang on 2017/3/2.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("代理开始了");
        Object result = method.invoke(target,args);
        System.out.println("代理执行结果:"+result);

        return result;
    }
}
