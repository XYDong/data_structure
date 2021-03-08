package com.company.rbtree;

/**
 * @version 1.0.0
 * @ClassName BSTMap.java
 * @Package com.company.map
 * @Author Joker
 * @Description 红黑树
 * @CreateTime 2021年01月21日 10:56:00
 */

import com.company.map.Map;

/**
 * 红黑树的性质：和2-3树一样，是一个保持“黑平衡”的二叉树，黑色节点高度差保持为1
 * 1.每个节点不是黑色就是红色的
 * 2.根节点一定是黑色的
 * 3.每一个叶子节点（最后的空节点）是黑色的
 * 4.如果一个节点是红色的，那么他的孩子节点都是黑色的
 * 5.从任意一个节点到叶子节点，经过的黑色节点是一样的
 */
public class RBTree<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;
    private static final boolean RED = true;
    private static final boolean BLACK = false;


    public RBTree() {
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
    /**
     * 方法描述: <br>
     * <p> 判断节点是不是红色的 </p>
     *
     * @Author Joker
     * @CreateDate 2021/3/8 15:40
     * @param node
     * @return boolean
     * @ReviseName 
     * @ReviseTime 2021/3/8 15:40
     **/
    public boolean isRed(Node node){
        if (node == null) {
            return BLACK;
        }
        return node.color == RED;
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

    /**
     * 方法描述: <br>
     * <p> 左旋转 </p>
     *
     * @Author Joker
     * @CreateDate 2021/3/8 15:43
     * @param node
     * @return RBTree<K,Node></K,Node>
     * @ReviseName 
     * @ReviseTime 2021/3/8 15:43
     **/
    private Node leftRotate(Node node){
        Node x = node.right;
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;
        return node;
    }
    /**
     * 方法描述: <br>
     * <p> 右旋转 </p>
     *
     * @Author Joker
     * @CreateDate 2021/3/8 15:47
     * @param node
     * @return RBTree<K,Node></K,Node>
     * @ReviseName
     * @ReviseTime 2021/3/8 15:47
     **/
    private Node rightRotate(Node node){
        Node x = node.left;
        // 右旋转
        node.left = x.right;
        x.right = node;
        //维护颜色
        x.color = node.color;
        node.color = RED;
        return node;
    }

    /**
     * 方法描述: <br>
     * <p> 颜色翻转 </p>
     *
     * @Author Joker
     * @CreateDate 2021/3/8 15:58
     * @param node
     * @return void
     * @ReviseName 
     * @ReviseTime 2021/3/8 15:58
     **/
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
        // 根节点一定是黑色的
        root.color = BLACK;
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
            // 默认红色节点
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key,value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key,value);
        } else {
            node.value = value;
        }
        // 红黑树维护
        if(isRed(node.right) && !isRed(node.left)) {
            leftRotate(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
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
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }
}
