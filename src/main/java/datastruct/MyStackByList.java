package datastruct;

import java.util.LinkedList;

public class MyStackByList {

    LinkedList linkedList;

    int size;

    int capacity;

    MyStackByList(int capacity){
        linkedList = new LinkedList();
        this.capacity = capacity;
        size = 0;
    }

    public void push(int element){
        if(size+1>capacity){
            throw new IndexOutOfBoundsException("栈溢出");
        }
        linkedList.add(size,element);
        size++;
    }

    public int pop(){
        if(size == 0){
            throw new IndexOutOfBoundsException("栈已空");
        }
        int result = (int) linkedList.get(size-1);
        linkedList.add(size-1,null);
        size--;
        System.out.println(result);
        return result;
    }



    public static void main(String[] args){
        MyStackByList myStackByList = new MyStackByList(3);
        myStackByList.push(1);
        myStackByList.push(2);
        myStackByList.push(3);
        myStackByList.pop();
        myStackByList.pop();
        myStackByList.pop();
    }
}


