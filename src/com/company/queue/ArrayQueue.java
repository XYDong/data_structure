package com.company.queue;

import com.company.array.Array;

/**
 * 功能描述: <br>
 * <p>〈队列实现〉</p>
 *
 * @author Joker
 * @ClassName ArrayQueue
 * @date 2020/12/23 9:32
 * @Version 1.0
 * @ReviseName:
 * @ReviseTime: 2020/12/23 9:32
 */
public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }
    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }
    public int getCapacity(){
        return array.getCapacity();
    }


    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d ", array.getSize()));
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
