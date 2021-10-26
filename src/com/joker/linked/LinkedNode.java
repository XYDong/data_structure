package com.joker.linked;

import java.util.Random;
import java.util.Stack;

/**
 * @version 1.0.0
 * @ClassName LinkedNode.java
 * @Package com.joker.linked
 * @Author Joker
 * @Description 单向链表操作
 * @CreateTime 2021年10月25日 16:02:00
 */
public class LinkedNode<T> {

    static class Node<T>{
        private T t;
        private Node<T> next;

        public Node(T t, Node<T> next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this(t,null);
        }

        public T getT() {
            return t;
        }
    }

    private Node<T> dummyHead;
    private int size;

    public LinkedNode() {
        this(null);
    }

    public LinkedNode(Node<T> dummyHead) {
        this.dummyHead = new Node<>(null);
        this.size = 0;
    }

    /**
     * 向链表头部添加元素
     * @param t 元素
     */
    public void addFirst(T t){
        add(t,0);
    }

    /**
     * 向末尾添加元素
     * @param t 元素
     */
    public void addLast(T t) {
        this.add(t,size);
    }

    /**
     * 向指定位置添加元素
     * @param t 元素
     * @param index 位置
     */
    private void add(T t, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of bounds");
        }
        Node<T> preNode = this.dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.next = new Node<>(t,preNode.next);
        this.size++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 查询t 元素在链表中的 位置
     * @param t
     * @return
     */
    public int getIndex(T t){
        Node<T> pre = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (pre.getT().equals(t)) {
                return i;
            }
        }
        return -1;
    }
    public Node<T> getNode(int index){
        Node<T> pre = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (index == i) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public T deleteFirst(){
        return delete(0);
    }

    public T deleteLast(){
        if (this.dummyHead.next == null) {
            return null;
        }
        return delete(size-1);
    }

    /**
     * 删除指定位置的元素
     * @param index
     */
    private T delete(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index out of bounds");
        }
        Node<T> pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node<T> delNode = pre.next;
        if (delNode != null) {
            pre.next = delNode.next;
        }
        size--;
        return delNode.t;
    }

    /**
     * 链表翻转
     * 三种方法：
     *  1. 递归
     *  2. 遍历
     *  3. 栈
     * @return
     */
    public void reverse(){
        // 递归
//        this.dummyHead.next = reverseRecursion(this.dummyHead.next);
        // 遍历
//        this.dummyHead.next =reverseTraverse(this.dummyHead.next);
        // 栈实现
        this.dummyHead.next =reverseTraverse(this.dummyHead.next);
    }

    /**
     * 遍历解法
     * @param node
     * @return
     */
    private Node<T> reverseTraverse(Node<T> node) {
        Node<T> pre = null;
        Node<T> next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     * 栈解法
     * @param node
     * @return
     */
    private Node<T> reverseStack(Node<T> node) {
        Stack stack = new Stack();
        Node<T> cur = node;
        while (node != null) {
            stack.add(cur);
            cur = cur.next;
        }
        Node<T> reNode = (Node<T>) stack.pop();
        while (!stack.empty()) {
            Node<T> pop = (Node<T>) stack.pop();
            reNode.next = pop;
        }
        return reNode;
    }



    /**
     * 递归写法
     * 思路：
     * @return
     */
    public Node<T> reverseRecursion(Node<T> node){
        if (node == null || node.next == null) {
            return node;
        }
        Node<T> reverse = reverseRecursion(node.next);
        node.next.next = node;
        node.next = null;
        return reverse;
    }

    /**
     * 环的检测
     *
     * 思路：
     *  1. 快慢指针：如果有环，则
     * @return
     */
    public boolean detectionRing(){
        Node<T> slow = this.dummyHead.next;
        Node<T> fast = this.dummyHead.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow ){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("该链表的数据：\n");
        Node<T> pre = dummyHead.next;
        while (pre != null) {
            builder.append(pre.t).append("\n");
            pre = pre.next;
        }
        return builder.toString().trim();
    }
    public static LinkedNode<Integer> createRing(int length, int start){
        LinkedNode<Integer> linkedNode = new LinkedNode<>();
        for (int i = 0; i < length; i++) {
            linkedNode.addLast(i);
        }
        Node<Integer> startNode = linkedNode.getNode(start);
        Node<Integer> lastNode = linkedNode.getNode(linkedNode.size -1);
        lastNode.next = startNode;
        return linkedNode;
    }
    public static void main(String[] args) {
//        LinkedNode<Integer> integerLinkedNode = new LinkedNode<>();
//        for (int i = 0; i < 10; i++) {
//            integerLinkedNode.addLast(i);
//        }
//        System.out.println("删除前的数据：\n"+integerLinkedNode.toString());
//        integerLinkedNode.deleteFirst();
//        System.out.println("删除第一个数据的数据：\n"+integerLinkedNode.toString());
//        integerLinkedNode.deleteLast();
//        System.out.println("删除最后一个数据的数据：\n"+integerLinkedNode.toString());
//        integerLinkedNode.reverse();
//        System.out.println("链表反转后的数据：\n"+integerLinkedNode.toString());
//        System.out.println("**************************************************************");

        //检测链表是否有环
        LinkedNode<Integer> ring = createRing(10, 5);
        System.out.println("链表是否有环："+ring.detectionRing());

        // 两个有序链表的合并
        LinkedNode<Integer> linkedNode1 = new LinkedNode<>();
        Random random = new Random(100);
        for (int i = 0; i < 10; i++) {
            linkedNode1.addLast(random.nextInt());
        }
        LinkedNode<Integer> linkedNode2 = new LinkedNode<>();
        for (int i = 0; i < 15; i++) {
            linkedNode2.addLast(random.nextInt());
        }
        // 合并
        if (linkedNode1.size > linkedNode2.size) {
            Node<Integer> node = linkedNode1.getNode(0);
            while (node != null){

            }
        }
    }
}
