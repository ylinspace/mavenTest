package org.yl.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yang on 2017/2/25.
 */
public class AppClient {

    public static void main(String [] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});

        context.start();

        DemoService service = (DemoService) context.getBean("demoService");

        for(int i=0;i<10000000;i++){
            String result = service.sayHello("zhang");

            User user = service.findUserById(12);

            System.out.println(user);

            System.out.println(result);
        }
    }
}
