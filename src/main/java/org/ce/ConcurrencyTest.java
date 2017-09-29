package org.ce;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by yang on 2017/2/9.
 */
public class ConcurrencyTest implements InvocationHandler {

    private static boolean flag ;

    public void run(){
        while(!flag){}
    }

    public static void main(String [] args) throws Exception{
        final Collection<Object> objects;
        //new ConcurrencyTest().start();
        Thread.sleep(100);
        flag = true;

        ExecutorService service = new ScheduledThreadPoolExecutor(100);
        //Future<String> future = service.submit(null);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List list = new ArrayList<String>();
        list.remove(1                   );


        return null;
    }
}
