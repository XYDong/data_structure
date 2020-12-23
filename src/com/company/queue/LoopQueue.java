package com.company.queue;

/**
 * 功能描述: <br>
 * <p>〈循环队列〉</p>
 *
 * @author Joker
 * @ClassName LoopQueue
 * @date 2020/12/23 10:22
 * @Version 1.0
 * @ReviseName:
 * @ReviseTime: 2020/12/23 10:22
 */
public class LoopQueue<E> implements Queue<E> {

    // 队列数组
    private E[] data;
    // 队首和元素下一个位置
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E datum = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getSize() / 4) {
            resize(getCapacity() / 2);
        }
        return datum;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d ", size));
        res.append("front [");
        for (int i = front; i != tail ; i = ( i + 1) % data.length ) {
            res.append(data[i]);
            if ( (i + 1) % data.length != tail ) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
