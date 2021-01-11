package com.company.queue;

import com.company.linkedlist.LinkedList;

/**
 * @version 1.0.0
 * @ClassName LinkedListQueue.java
 * @Package com.company.queue
 * @Author Joker
 * @Description 用链表实现队列
 * @CreateTime 2021年01月11日 10:04:00
 */
public class LinkedListQueue<E> implements Queue<E> {

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

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }
    // 获取元素个数
    @Override
    public int getSize() {
        return size;
    }

    // 链表是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head.next == null) {
            tail = null;
        }
        delNode = null;
        size --;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot getFront from an empty queue.");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL taill");
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
