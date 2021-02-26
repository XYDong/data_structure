package com.company.avltree;


import java.util.ArrayList;

/**
 * @version 1.0.0
 * @ClassName BSTMap.java
 * @Package com.company.map
 * @Author Joker
 * @Description 二分搜索树的映射实现
 * @CreateTime 2021年01月21日 10:56:00
 */
public class AVLTree<K extends Comparable<K>, V>{

    private Node root;
    private int size;

    public AVLTree() {
        this.root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

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
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V getValue(K key) {
        Node node = getNode(root, key);
        return node == null? null: node.value;
    }

    public void setValue(K key, V value) {
        Node node = getNode(root, key);
        if(node != null) {
            node.value = value;
        }
    }

    /**
     * 方法描述: <br>
     * <p> 获取node的高度 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/25 11:16
     * @param node
     * @return int
     * @ReviseName 
     * @ReviseTime 2021/2/25 11:16
     **/
    private int getHeight(Node node){
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 方法描述: <br>
     * <p> 计算平衡因子 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/25 11:26
     * @param node
     * @return int
     * @ReviseName 
     * @ReviseTime 2021/2/25 11:26
     **/
    private int getBalanceFactor(Node node){
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
    /**
     * 方法描述: <br>
     * <p> 是否是二分搜索树 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/25 13:17
     * @param 
     * @return boolean
     * @ReviseName 
     * @ReviseTime 2021/2/25 13:17
     **/
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root,keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i -1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    /**
     * 方法描述: <br>
     * <p> 判断二叉树是不是平衡二叉树 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/25 13:20
     * @param
     * @return boolean
     * @ReviseName
     * @ReviseTime 2021/2/25 13:20
     **/
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    // 对节电Y进行向右选装操作，返回旋转后的新的根节点x
    //           y                              x
    //          / \                            / \
    //         x    T4                        z    y
    //        / \                            / \  / \
    //       z  T3                          T1 T2 T3 T4
    //      / \
    //    T1  T2
    private Node rightRotate(Node y){
        Node x = y.left;
        Node t3 = x.right;

        x.right = y;
        y.left = t3;

        // 维护平衡因子
        y.height = Math.max(getHeight(y.left) ,getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left) ,getHeight(x.right)) + 1;
        return x;
    }
    private Node leftRotate(Node y){
        Node x = y.right;
        Node t3 = x.left;

        x.left = y;
        y.right = t3;

        // 维护平衡因子
        y.height = Math.max(getHeight(y.left) ,getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left) ,getHeight(x.right)) + 1;
        return x;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
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
        } else {
            node.value = value;
        }

        // 更新height
        node.height = 1 +  Math.max(getHeight(node.left),getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        // 平衡维护
//        if (Math.abs(balanceFactor) > 1) {
//            System.out.println("unbalanced : " + balanceFactor);
//
//        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
//        System.out.println("isBST: " + isBST());
//        System.out.println("isBalanced: " + isBalanced());
        return node;
    }



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
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left,key);
            retNode =  node;
        } else if (key.compareTo(node.key) > 0) {
            node.right =remove(node.right,key);
            retNode =  node;
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size --;
                retNode =  right;
            } else if (node.right == null){
                Node left = node.left;
                node.left = null;
                size--;
                retNode =  left;
            } else {
                Node minimum = minimum(node.right);
                minimum.right = remove(node.right,minimum.key);
                minimum.left = node.left;
                node.left = node.right = null;
                retNode =  minimum;
            }
        }
        if (retNode == null) {
            return null;
        }
        // 更新height
        retNode.height = 1 +  Math.max(getHeight(retNode.left),getHeight(retNode.right));
        int balanceFactor = getBalanceFactor(retNode);
        // 平衡维护
//        if (Math.abs(balanceFactor) > 1) {
//            System.out.println("unbalanced : " + balanceFactor);
//
//        }
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            return rightRotate(retNode);
        }
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
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
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }
}
