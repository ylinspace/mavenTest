package org.yl;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yang on 2017/2/22.
 */
public class AlgorithmTest {

    public AlgorithmTest() {
    }

    public static void main(String args []) throws Exception{

        int [] array = new int [] {5,2,7,5,9,1,2,0,6,2};

        sort(array);

        for (int i=0;i< array.length;i++){
            System.out.println(array[i]);
        }

    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    private static void bubbleSort(int [] array){
        for(int i=0;i<array.length - 1;i++){
            for(int j =0;j < array.length - 1 - i;j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    private static void sort(int [] array){
        for(int i=0;i<array.length;i++){
            for(int j =i+1 ;j<array.length;j++){
                if(array[i]> array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }


}
