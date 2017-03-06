package org.yl.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏
 * Created by yang on 2017/3/5.
 */
public class CyclicBarrierTest {

    static class WorkerThread implements Runnable{

        CyclicBarrier barrier ;

        public WorkerThread(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try{
                System.out.println("线程ID："+Thread.currentThread().getId()+"，已就位！");
                barrier.await();
                System.out.println("线程ID："+Thread.currentThread().getId()+"，工作中。。。");
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        }
    }

    public static void main(String [] args){
        int threadNum = Runtime.getRuntime().availableProcessors();
        CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {
            @Override
            public void run() {
                System.out.println("OK，都到齐了，大家开工吧！");
            }
        });
        for(int i=0;i<threadNum;i++){
            new Thread(new WorkerThread(barrier)).start();
        }
    }

}

/*
Run result：
线程ID：10，已就位！
线程ID：11，已就位！
线程ID：12，已就位！
线程ID：13，已就位！
OK，都到齐了，大家开工吧！
线程ID：13，工作中。。。
线程ID：10，工作中。。。
线程ID：12，工作中。。。
线程ID：11，工作中。。。*/
