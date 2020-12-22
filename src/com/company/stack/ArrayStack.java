package com.company.stack;

import com.company.array.Array;

/**
 * 功能描述: <br>
 * <p>〈〉</p>
 *
 * @author Joker
 * @ClassName ArrayStack
 * @date 2020/12/22 14:05
 * @Version 1.0
 * @ReviseName:
 * @ReviseTime: 2020/12/22 14:05
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public int getCapacity() {
        return array.getCapacity();
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack: size = %d ", array.getSize()));
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
