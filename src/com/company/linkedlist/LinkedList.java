package com.company.linkedlist;

/**
 * @version 1.0.0
 * @ClassName LinkedList.java
 * @Package com.company.linkedlist
 * @Author Joker
 * @Description 链表
 * @CreateTime 2021年01月07日 13:45:00
 */
public class LinkedList<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;


    public LinkedList() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    // 获取元素个数
    public int getSize() {
        return size;
    }

    // 链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向指定位置添加元素
    public void add(int index , E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size ++;

    }
    // 在链表头添加元素
    public void addFirst(E e) {
        add(0,e);
    }
    // 向链表末尾添加元素
    public void addLast(E e) {
        add(size,e);
    }

    // 获取指定位置的元素
    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    public int getIndex(E e){
        if (e == null) {
            throw new IllegalArgumentException("Get index failed. Illegal e.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (cur.e.equals(e)) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    // 获取第一个位置的元素
    public E getFirst() {
        return get(0);
    }
    // 获取最后位置的元素
    public E getLast() {
        return get(size -1);
    }

    // 设置指定位置的值
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表汇总是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 删除指定位置的元素
    public E delete(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Delete failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode = null;
        size --;
        return delNode.e;
    }
    public E deleteFirst() {
        return delete(0);
    }
    public E deleteLast(){
        return delete(size -1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

}
