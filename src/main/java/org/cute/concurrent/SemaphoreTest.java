package org.cute.concurrent;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * Created by yang on 2017/3/5.
 */
public class SemaphoreTest {

    private static final Semaphore sem = new Semaphore(10);

    public static void main(String [] args){

        for(int i=0;i<100;i++){

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //信号量许可获取
                        sem.acquire();
                        System.out.println("线程："+Thread.currentThread().getId()+"开始工作。。。");
                        Thread.sleep(3000);
                        System.out.println("线程："+Thread.currentThread().getId()+"收工！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //信号量许可释放
                        sem.release();
                    }
                }
            });
            t.start();
        }
    }
}
