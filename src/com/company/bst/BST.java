package com.company.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version 1.0.0
 * @ClassName BST.java
 * @Package com.company.bst
 * @Author Joker
 * @Description 二分搜索树
 * @CreateTime 2021年01月11日 16:40:00
 */
public class BST<E extends Comparable<E>>{

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e){
        if (root == null) {
            root  = new Node(e);
            size ++;
        } else {
            add(root,e);
        }

    }
    // 添加元素
    private Node add( Node node, E e){

        if (node == null) {
            size ++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left,e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right,e);
        }
        return node;
    }
    public boolean contatins(E e){
        return contatins(root,e);
     }
    public boolean contatins(Node node,E e){
        if (node == null) {
            return false;
        }
        if (e.equals(node.e)) {
            return true;
        } else if(e.compareTo(node.e) < 0 ) {
            return contatins(node.left,e);
        } else {
            return contatins(node.right,e);
        }
     }

     // 二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }
    // 二分搜索树前序序遍历（非递归:栈）
    public void preOrderNR(){
        preOrderNR(root);
    }

    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop.e);

            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }

        }
    }
    // 二分搜索树前序序遍历（非递归：队列）
    public void preOrderQ(){
        preOrderQ(root);
    }

    private void preOrderQ(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.e);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }
    // 二分搜索树中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    // 二分搜索树后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 找出二分树的最小元素
    public E minimum(){
        if (size == 0) {
           throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    // 找出二分树的最大元素
    public E maximum(){
        if (size == 0) {
           throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }
    // 删除二分搜索树最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    // 删除二分搜索树最大值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left,e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right =remove(node.right,e);
            return node;
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size --;
                return right;
            } else if (node.right == null){
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            } else {
                Node minimum = minimum(node.right);
                minimum.left = node.left;
                minimum.right = removeMin(node.right);
                node.left = node.right = null;
                return minimum;
            }

        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0 , sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth) + "null\n");
            return;
        }
        sb.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth +1,sb);
        generateBSTString(node.right,depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
