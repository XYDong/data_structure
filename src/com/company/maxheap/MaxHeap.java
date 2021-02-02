package com.company.maxheap;

import com.company.array.Array;

/**
 * @version 1.0.0
 * @ClassName MaxHeap.java
 * @Package com.company.maxheap
 * @Author Joker
 * @Description 用数组实现最大堆
 * @CreateTime 2021年01月25日 11:02:00
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] es){
        data = new Array<>();
        for (int i = parent(es.length - 1); i > 0 ; i--) {
            siftDown(i);
        }
    }
    /**
     * 获取元素个数
     */
    public int getSize(){
        return data.getSize();
    }

    /**
     * 堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 获取父节点的索引值
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index is not have parent");
        }
        return (index - 1 ) / 2;
    }

    /**
     * 获取左孩子的索引值
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取index索引的右孩子索引值
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 插入元素
     * @param k
     */
    public void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    /**
     * 获取堆中最大的元素
     * @return E
     */
    public E findMax(){
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    /**
     * 删除最大值
     * @return
     */
    public E extractMax() {
        E max = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    private void siftDown(int i) {
        while (leftChild(i) < data.getSize()) {
            int j = leftChild(i);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(i,j);
            i = j;
        }
    }

    /**
     *  取出对重的最大元素，并且替换成元素e
     * @param e
     * @return
     */
    public E replace(E e) {
        E max = findMax();
        data.add(0,e);
        siftDown(0);
        return max;
    }

}
