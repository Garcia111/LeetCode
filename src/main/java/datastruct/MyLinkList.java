package datastruct;

/**
 * @author：Cheng.
 * @date：Created in 16:30 2019/9/1
 */
public class MyLinkList {

    /**头结点指针*/
    private Node head;
    /**尾节点指针*/
    private Node last;
    /** 链表实际长度 */
    private int size;

    /**
     * 插入元素
     * @param data
     * @param index
     */
    public void insert(int data,int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("超出链表的实际长度");
        }

        if(index == 0){
            //在链表头部插入元素
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        }else if(index == size-1){
            //在链表尾部插入元素
            Node newLast = new Node(data);
            last.next = newLast;
            last = newLast;
        }else{
           //在链表中间插入元素
            Node node = new Node(data);
            Node preNode = this.get(index-1);
            Node nextNode = preNode.next;
            preNode.next = node;
            node.next = nextNode;
        }
        size++;

    }


    /**
     * 删除某个索引位置的元素
     * @param index
     * @return
     */
    public Node delete(int index){

        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("超出链表的实际范围");
        }
        Node deletedNode;
        if(index==0){
            deletedNode = head;
            head = head.next;
        }else if(index == size-1){
            deletedNode = last;
            last = this.get(size-2);
        }else{
            deletedNode = get(index-1);
            Node preNode = get(index-2);
            Node nextNode = preNode.next.next;
            preNode.next = nextNode;
        }
        size--;
        return deletedNode;
    }


    public Node get(int index){
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }


    public void output(){
        Node temp = head;
        for(int i=0; i<size; i++){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args){
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.insert(0,0);
        myLinkList.insert(1,1);
        myLinkList.insert(2,2);
        myLinkList.output();
        myLinkList.get(2).data = 3;
        myLinkList.output();
        myLinkList.delete(1);
        myLinkList.output();
    }


}

    class Node {

         int data;
         Node next;

        public Node(int data){
            this.data = data;
        }


    }
