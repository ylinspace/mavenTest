package org.yl.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yang on 2017/2/25.
 */
public class App {

    public static void main(String [] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});

        context.start();

        System.out.println("Dubbo provider start ...");

        try{
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
