package com.company.map;


/**
 * @version 1.0.0
 * @ClassName BSTMap.java
 * @Package com.company.map
 * @Author Joker
 * @Description 二分搜索树的映射实现
 * @CreateTime 2021年01月21日 10:56:00
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node;
        } else if (node.key.compareTo(key) < 0) {
            return getNode(node.right,key);
        } else {
            return getNode(node.left,key);
        }
    }
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V getValue(K key) {
        Node node = getNode(root, key);
        return node == null? null: node.value;
    }

    @Override
    public void setValue(K key, V value) {
        Node node = getNode(root, key);
        if(node != null) {
            node.value = value;
        }
    }

    @Override
    public void add(K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
        } else {
            add(root, key, value);
        }
    }

    /**
     * 方法描述: <br>
     * <p> // 添加元素 </p>
     *
     * @param node 树
     * @param key 键
     * @param value 值
     * @return BSTMap<K, Node>
     * @Author Joker
     * @CreateDate 2 0 2 1 / 1 / 2 1 1 4 : 2 1
     * @ReviseName
     * @ReviseTime 2 0 2 1 / 1 / 2 1 1 4 : 2 1
     **/
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key,value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key,value);
        }
        return node;
    }



    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root,key);
            return node.value;
        }
        return null;
    }
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left,key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right =remove(node.right,key);
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


    // 找出二分树的最小元素
    public Node minimum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root);
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
    // 找出二分树的最大元素
    public Node maximum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root);
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }
    // 删除二分搜索树最小值
    public Node removeMin(){
        Node ret = minimum();
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
    public Node removeMax(){
        Node ret = maximum();
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

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
