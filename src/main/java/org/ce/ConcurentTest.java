package org.ce;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yang on 2017/2/7.
 */
public class ConcurentTest {

    public static void main(String args []) throws Exception{
        final CountDownLatch latch = new CountDownLatch(1000);

        for(int i =0 ;i<1000 ;i++  ){
            System.out.println(i);
        }

        test(100);
        latch.await();

    }

    public static void test(int i){
        System.out.println(i);
    }

}
