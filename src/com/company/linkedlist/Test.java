package com.company.linkedlist;

/**
 * @version 1.0.0
 * @ClassName Test.java
 * @Package com.company.linkedlist
 * @Author Joker
 * @Description 测试链表
 * @CreateTime 2021年01月07日 15:02:00
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList.toString());
        linkedList.delete(2);
        System.out.println(linkedList.toString());
    }
}
