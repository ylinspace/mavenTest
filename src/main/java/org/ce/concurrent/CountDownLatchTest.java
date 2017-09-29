package org.ce.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * Created by yang on 2017/3/5.
 */
public class CountDownLatchTest {

    public static void main(String [] args ) throws InterruptedException {

        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(2000);

        for(int i=0;i<2000;i++){
            System.out.println(i);
            Thread t = new Thread(){
                public void run( ){
                    try{
                        //等待直到计数器清零
                        startGate.await();
                        try {
                            Thread.sleep(1000);//模拟任务执行时间
                        }catch(Exception e){
                            e.printStackTrace();
                        }finally {
                            endGate.countDown();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }

        long start = System.currentTimeMillis();
        startGate.countDown();//事件已发生，计数器递减
        endGate.await();
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

}
