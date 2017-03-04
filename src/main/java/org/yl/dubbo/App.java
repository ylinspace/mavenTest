package org.yl.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yang on 2017/2/25.
 */
public class App {

    public static void main(String [] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});

        context.start();

        System.out.println("Dubbo provider start ...");

        InvocationHandler a;

        try{
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
