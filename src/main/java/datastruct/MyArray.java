
package datastruct;

/** 数组的插入删除
 * @author：Cheng.
 * @date：Created in 15:35 2019/9/1
 */
public class MyArray {

    private int[] array;
    /** 数组中实际元素的个数，数组中元素的索引为0~size-1 */
    private int size;

    public MyArray(int capacity){
        array = new int[capacity];
        this.size = 0;
    }


    public void output(){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


    /***
     * 插入元素
     * @param element 插入的元素
     * @param index 插入元素的位置
     * @throws Exception
     */
    public void insert(int element, int index) throws Exception{
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("超出数组的实际索引范围");
        }
        if(size >= array.length){
            resize();
        }
        //否则将数组中插入位置右侧的元素逐个向右侧进行移动
        for(int i= size-1;i>=index;i--){
            array[i]=array[i+1];
        }
        array[index] = element;
        size = size+1;
    }

    /**
     * 删除指定位置上的元素
     * @param index
     * @return
     * @throws Exception
     */
    public int delete(int index) throws Exception{
        System.out.println("删除元素");
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("超出数组的实际元素范围");
        }

        int deleteElement = array[index];
        //将右侧元素向左移动一位
        for(int i = size-1; i>index; i--){
            array[i-1]=array[i];
        }
        array[size-1]=0;
        size --;
        return deleteElement;
    }

    /**
     * 扩容
     */
    public void resize(){
        System.out.println("进行扩容");
        int[] newArray = new int[size*2];
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }


    public static void main(String[] args) throws Exception {
        MyArray a = new MyArray(3);
        a.insert(1,0);
        a.output();
        a.insert(5,1);
        a.output();
        a.insert(2,2);
        a.output();
        a.insert(3,3);
        a.insert(4,4);
        a.insert(5,5);
        a.output();
        a.delete(5);
        a.output();
   }
}
