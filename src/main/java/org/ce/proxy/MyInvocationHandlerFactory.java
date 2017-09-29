package org.ce.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by yang on 2017/3/2.
 */
public class MyInvocationHandlerFactory {

    public static Object getProxyObject(Object target) throws Exception{

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(target);

        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);


    }

}
