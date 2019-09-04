package datastruct;

public class MyStackByArray {

    private int[] array;
    private int size;

    public MyStackByArray(int capacity){
        array = new int[capacity];
        size=0;
    }


    public void push(int element){
        if(size+1>array.length){
            resize();
        }
        array[size] = element;
        size++;
    }

    public int pop(){
        if(array.length == 0){
            throw new IndexOutOfBoundsException("栈已为空");
        }
        int result = array[size-1];
        array[size-1]=0;
        size--;
        System.out.println(result);
        return result;
    }

    public void resize(){
        int[] newArray = new int[array.length*2];
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }

    public static void main(String[] args){
        MyStackByArray myStackByArray = new MyStackByArray(5);
        myStackByArray.push(1);
        myStackByArray.push(2);
        myStackByArray.push(3);
        myStackByArray.pop();
        myStackByArray.pop();
        myStackByArray.pop();
    }
}
