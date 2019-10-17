package datastruct;

import java.util.*;

/**
 * @author：Cheng.
 * @date：Created in 9:06 2019/10/16
 */
public class TwoBinaryTreeTest {

    static class TreeNode {

        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;


        TreeNode(int data){
            this.data = data;
        }

        public int getData(){
            return data;
        }
    }

    /**
     * 构建二叉树
     * @param treeNodeDateList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> treeNodeDateList){
        if(treeNodeDateList == null || treeNodeDateList.size() == 0){
            return null;
        }
        TreeNode node = null;
        Integer data = treeNodeDateList.remove();
        if(data != null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(treeNodeDateList);
            node.rightChild = createBinaryTree(treeNodeDateList);
        }
        return node;
    }

    /**
     * 二叉树的先序遍历实现：根 左 右
     * @param rootNode
     */
    public static void preOrderTravelWithDigui(TreeNode rootNode){
        if(rootNode == null){
            return;
        }
        //先打印输出根节点
        System.out.println(rootNode.getData());
        //再打印左子树
        preOrderTravelWithDigui(rootNode.leftChild);
        //再打印右子树
        preOrderTravelWithDigui(rootNode.rightChild);
    }


    /**
     * 使用递归实现二叉树的中序遍历：左 根 右
     * @param rootNode
     */
    public static void midOrderTravelWithDigui(TreeNode rootNode){
        if(rootNode == null){
            return;
        }
        midOrderTravelWithDigui(rootNode.leftChild);
        System.out.println(rootNode.getData());
        midOrderTravelWithDigui(rootNode.rightChild);
    }


    /**
     * 后续遍历二叉树：左 右 根
     * @param rootNode
     */
    public static void postOrderTravelWithDigui(TreeNode rootNode){
        if(rootNode == null){
            return;
        }
        postOrderTravelWithDigui(rootNode.leftChild);
        postOrderTravelWithDigui(rootNode.rightChild);
        System.out.println(rootNode.getData());
    }


    /**
     * 层序遍历
     * @param node
     */
    public static void levelOrderTraversal(TreeNode node){

        //使用队列来存储树节点，可是实现层序遍历,每出队一个node，就讲它的左、右子树按顺序加入队里
        Queue queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            TreeNode treeNode = (TreeNode) queue.poll();
            System.out.println(treeNode.getData());
            if(treeNode.leftChild != null){
                queue.offer(treeNode.leftChild);
            }
            if(treeNode.rightChild != null){
                queue.offer(treeNode.rightChild);
            }
        }
    }


    /**
     * 使用栈实现先序遍历
     * @param node
     */
    public static void preOrderTravelWithStack(TreeNode node){

        if(node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            while(node != null){
              stack.push(node);
              System.out.println(node.data);
              node = node.leftChild;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }


    /**
     * 二叉树的中序遍历实现: 左 中 右
     * @param treeNode
     */
    public static void midOrderTraveralWithStack(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(treeNode != null || !stack.isEmpty()){
            while(treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                //如果左子树为空，弹出该左子树的父节点
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 使用栈实现二叉树的后续遍历,
     * @param treeNode
     */
    public static void postOrderTraversalWithStack(TreeNode treeNode){
        //todo 这个好复杂，搞不懂
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = treeNode;
        TreeNode tempNode = null;
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.leftChild;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                tempNode = node.rightChild;
                if(tempNode != null){
                    node.rightChild = null;
                    stack.push(node);
                }else{
                    System.out.println(node.data);
                }
                node = tempNode;
            }
        }
    }




    public static void main(String[] args) {

        //构建二叉树的过程其实就是先序遍历的过程
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode node = createBinaryTree(inputList);

        System.out.println("层序遍历：");
        levelOrderTraversal(node);

        System.out.println("前序遍历递归实现：");
        preOrderTravelWithDigui(node);

        System.out.println("前序遍历栈实现：");
        preOrderTravelWithStack(node);

        System.out.println("中序遍历递归实现：");
        midOrderTravelWithDigui(node);

        System.out.println("中序遍历栈实现：");
        midOrderTraveralWithStack(node);

        System.out.println("后序遍历递归实现：");
        postOrderTravelWithDigui(node);

        System.out.println("后序遍历栈实现：");
        postOrderTraversalWithStack(node);

    }
}


