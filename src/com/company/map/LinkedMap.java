package com.company.map;

import com.company.linkedlist.LinkedList;

/**
 * @version 1.0.0
 * @ClassName LinkedMap.java
 * @Package com.company.map
 * @Author Joker
 * @Description 链式map
 * @CreateTime 2021年01月21日 09:32:00
 */
public class LinkedMap<K, V> implements Map<K, V> {

    private Node dummyHead;
    private int size;
    public LinkedMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V getValue(K key) {
        return getNode(key) != null ? getNode(key).value : null;
    }

    /**
     * 方法描述: <br>
     * <p> 通过key获取Node </p>
     *
     * @param key 键
     * @return LinkedMap<K, v>>
     * @Author Joker
     * @CreateDate 2021/1/21 9:56
     * @ReviseName
     * @ReviseTime 2021/1/21 9:56
     **/
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur.next != null) {
            if (cur.key.equals(key)) {
                return cur;
            } else {
                cur = cur.next;
            }
        }
        return null;
    }

    @Override
    public void setValue(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn‘t exist!");
        }
        node.value =value;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key,value,dummyHead.next);
            size ++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead.next;
        while (prev.next != null) {
            if (prev.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }
        return null;
    }

    @Override
    public String toString() {
        return "LinkedMap{" +
                "dummyHead=" + dummyHead +
                ", size=" + size +
                '}';
    }

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }

        public Node(K key, V value) {
            this(key, value, null);
        }
    }
}
