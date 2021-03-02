package com.company.set;

import com.company.avltree.AVLTree;

/**
 * @version 1.0.0
 * @ClassName AVLSet.java
 * @Package com.company.set
 * @Author Joker
 * @Description 基于平衡二叉树的集合
 * @CreateTime 2021年03月02日 09:42:00
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E,Object> avlTree;

    public AVLSet() {
        this.avlTree = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avlTree.add(e,null);
    }

    @Override
    public void remove(E e) {
        avlTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avlTree.contains(e);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
