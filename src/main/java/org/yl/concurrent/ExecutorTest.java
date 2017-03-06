package org.yl.concurrent;

import com.mysql.jdbc.TimeUtil;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * Created by yang on 2017/3/5.
 */
public class ExecutorTest {

    public static void main(String [] args) throws Exception{
//        ExecutorService executor = Executors.newCachedThreadPool();//JDK建议尽量使用该方法，避免参数配置
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,20,1000,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(10));
        for(int i=0;i<15;i++){
            executor.execute(new MyTask(i));
            System.out.println("线程池中线程数量："+executor.getPoolSize()+",队列中任务数量："+
                    executor.getQueue().size());
        }
        ThreadPoolTaskExecutor a;
        Future<?> f = executor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "ok";
            }
        });

        System.out.println("执行结果："+f.get());
        executor.shutdown();
    }

    static class MyTask implements Runnable{

        private int num;

        public MyTask(int num){
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("线程："+num+"开始工作。。。");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程："+num+"收工了！");
        }
    }


}
