package datastruct;

import java.util.Arrays;

/**
 * @author：Cheng.
 * @date：Created in 14:48 2019/10/17
 */
public class TwoBinaryHeapTest {

    //二叉堆本质上是一种完全二叉树，分为两个类型：
    //1.最大堆：任何一个父节点的值，都大于或等于它的左右孩子节点的值；
    //2.最小堆：任何一个父节点的值，都小于或等于它的左右孩子节点的值。

    //二叉堆虽然是一个完全二叉树，但是它的存储方式并不是链式存储，而是顺序存储，是按照程序遍历的结果存储在数组中的
    //假设父节点的下表是parent，name它的左孩子的下标就是2*parent+1,右孩子的下标就是2*parent+2

    /**
     * 插入节点
     * @param array
     * @param node
     * @return
     */
    public static int[] insert(int[] array, int node){
        int[] newArray = new int[array.length+1];
        System.arraycopy(array,0,newArray,0,array.length);
        newArray[newArray.length-1] = node;
        upAdjust(newArray);
        return newArray;
    }


    public static int[] upAdjust(int[] array){

        int childIndex = array.length-1;
        int parentIndex = (childIndex-1)/2;
        int temp = array[childIndex];

        while (childIndex>0 && array[parentIndex]>temp){
            //parent 节点下沉
            array[childIndex] = array[parentIndex];
            //修改索引
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
        array[childIndex] = temp;
        return array;
    }


    public static void main(String[] args){
        int[] array = new int[]{1,3,2,6,5,7,8,9,10};
        System.out.println(Arrays.toString(insert(array,0)));
    }

}
