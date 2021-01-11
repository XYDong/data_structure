package com.company.stack;

import com.company.linkedlist.LinkedList;
import com.company.queue.Queue;

/**
 * @version 1.0.0
 * @ClassName LinkedListStack.java
 * @Package com.company.stack
 * @Author Joker
 * @Description 用链表实现栈
 * @CreateTime 2021年01月11日 09:51:00
 */
public class LinkedListStack<E> implements Stack<E>{
    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.deleteFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: top");
        sb.append(list);
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            listStack.push(i);
            System.out.println(listStack);
            if (i % 3 == 2) {
                listStack.pop();
                System.out.println(listStack);
            }
        }
    }
}
