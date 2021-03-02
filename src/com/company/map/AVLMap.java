package com.company.map;

import com.company.avltree.AVLTree;

/**
 * @version 1.0.0
 * @ClassName AVLMap.java
 * @Package com.company.map
 * @Author Joker
 * @Description 基于平衡二叉树的映射
 * @CreateTime 2021年03月02日 09:34:00
 */
public class AVLMap<K extends Comparable<K>,V> implements Map<K,V> {
    private AVLTree<K,V> avlTree;

    public AVLMap() {
        this.avlTree = new AVLTree<>();
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }

    @Override
    public boolean contains(K key) {
        return avlTree.contains(key);
    }

    @Override
    public V getValue(K key) {
        return avlTree.getValue(key);
    }

    @Override
    public void setValue(K key, V value) {
        avlTree.setValue(key, value);
    }

    @Override
    public void add(K key, V value) {
        avlTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }
}
