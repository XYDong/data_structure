package com.company.set;

import com.company.bst.BST;

/**
 * @version 1.0.0
 * @ClassName BSTSet.java
 * @Package com.company.set
 * @Author Joker
 * @Description 基于二分搜索树的集合
 * @CreateTime 2021年01月19日 15:49:00
 */
public class BSTSet <E extends Comparable<E>> implements Set<E>{

    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contatins(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
