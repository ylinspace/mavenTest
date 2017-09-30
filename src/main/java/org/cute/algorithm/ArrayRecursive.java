package org.cute.algorithm;

/**
 * Created by yang on 2017/3/3.
 */
public class ArrayRecursive {

    private static int num = 0;

    public static void main(String [] args){
        for(int i=0;i<12;i++){
            btArrayFunction(i);
        }
    }

    /**
     * 输入数字，该函数满足两个条件：
     * 1：数组中的数字为（1~n）*2，如：n=3，则数组中数字为：1,1,2,2,3,3
     * 2：数组中数字排序，排序后满足任意两个相同数字中间相隔该数字的个数，比如：3,x,x,x,3；该例子中两个3中间相隔3个数组元素
     * 请找出输入n数字后，能排序出来的多种排序情况。
     * 例子：n = 3 ，则全部排序输出有2种情况：3,1,2,1,3,2  2,3,1,2,1,3
     * @param num
     */
    static void btArrayFunction(int num){
        ArrayRecursive.num = num;
        int [] array = new int[num * 2];
        recursiveCall(array,0);
    }

    /**
     * 递归调用计算
     * @param tmp
     * @param start
     */
    static void recursiveCall(int [] tmp,int start){
        //从数组的start位置开始找为空的（即0）位置，填充该位置后结束该次递归
        for(int i =start;i< tmp.length;i++){
            if(tmp[i] == 0){
                //循环所有数字尝试填充该单元格
                for(int j =1;j<num+1;j++){
                    //过滤已经填充过的数字
                    if(isContainsNum(tmp,j)){
                        continue;
                    }
                    //i+相隔的数量j+1
                    int secondPosition = i+j+1;
                    //越界则当前数组排序失败，返回
                    if(secondPosition> tmp.length - 1){
                        return;
                    }
                    //该数字的第二个位置如果已填充，则继续尝试
                    if(tmp[secondPosition] != 0){
                        continue;
                    }
                    //复制为新的数组用于填充，每次填充都是一种可能的序列，因此需要复制
                    int [] tmp2 = arrayCopy(tmp);
                    tmp2[i] = j;
                    tmp2[secondPosition] = j;
                    //递归处理下一个填充位置
                    recursiveCall(tmp2,i+1);
                }
                break;
            }
        }

        //查看是否有为填充满的情况，未填充满则放弃该数组排序
        for(int i=0;i<tmp.length;i++){
            if(tmp[i] == 0){
                return;
            }
        }

        //打印已满足条件的排序数组
        for(int i=0;i<tmp.length;i++){
            System.out.print(tmp[i]+":");
            if(i == tmp.length - 1){
                System.out.println("长度:"+tmp.length/2);
            }
        }

        return;
    }

    /**
     * 复制数组
     * @param array
     * @return
     */
    static int [] arrayCopy(int [] array){
        int [] newArray = new int[array.length];
        for(int i =0 ;i< array.length;i++){
            newArray[i] = array[i];
        }
        return newArray;
    }

    /**
     * 数组中是否包含某数字
     * @param array
     * @param k
     * @return
     */
    static boolean isContainsNum(int [] array,int k){
        for(int i =0;i< array.length;i++){
            if(array[i] == k){
                return true;
            }
        }
        return false;
    }
}
