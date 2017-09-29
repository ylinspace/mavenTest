package org.ce.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by yang on 2017/3/5.
 */
public class FutureTaskTest {

    private final FutureTask future = new FutureTask(new Callable() {
        @Override
        public Object call() throws Exception {
            Thread.sleep(3000);
            return "ok";
        }
    });

    private final Thread thread = new Thread(future);

    public void start(){
        thread.start();
    }

    public Object get() throws Exception{
        return future.get();
    }

    public static void main(String [] args) throws Exception {
        FutureTaskTest t = new FutureTaskTest();
        t.start();
        System.out.println(t.get());
    }

}
