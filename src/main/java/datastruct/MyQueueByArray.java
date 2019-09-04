package datastruct;


/**
 * 使用数组实现循环队列
 */
public class MyQueueByArray {

    private int[] array;
    //头索引
    private int front;
    //尾索引
    private int rear;


    public MyQueueByArray(int capacity){
        array = new int[capacity];
        front = 0;
        rear = 0;
    }


    public  void insert(int element){
        if((rear+1)%array.length == front){
            throw new IndexOutOfBoundsException("队列已满");
        }
        array[rear] = element;
        rear= (rear+1)%array.length;
    }

    public int delete(){
        if(front == rear){
            throw new IndexOutOfBoundsException("队列已空");
        }
        int result = array[front];
        front = (front+1)%array.length;
        System.out.println(result);
        return result;
    }


    public static void main(String[] args){
        MyQueueByArray myQueueByArray = new MyQueueByArray(3);
        myQueueByArray.insert(1);
        myQueueByArray.insert(2);
        myQueueByArray.insert(3);
        myQueueByArray.delete();
        myQueueByArray.delete();
        myQueueByArray.delete();
        myQueueByArray.delete();
    }

}
