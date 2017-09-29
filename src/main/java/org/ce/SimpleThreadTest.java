package org.ce;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yang on 2017/2/8.
 */
public class SimpleThreadTest {

    static class Simple extends Thread{
        public void run(){
            while(true){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId()+"running 。。。");
            }

        }
    }


    public static void main(String [] args){
        for(int i=0;i<10;i++){
            Simple s = new Simple();
            s.start();
        }

        AtomicLong count = new AtomicLong(0 );
        count.incrementAndGet();
        count.get();
    }
}
