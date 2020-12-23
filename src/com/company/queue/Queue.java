package com.company.queue;

/**
 * 功能描述: <br>
 * <p>〈队列接口〉</p>
 *
 * @author Joker
 * @ClassName Queue
 * @date 2020/12/23 9:31
 * @Version 1.0
 * @ReviseName:
 * @ReviseTime: 2020/12/23 9:31
 */
public interface Queue<E> {
    // 添加元素
    void enqueue(E e);
    // 删除元素
    E dequeue();
    // 获取队首的元素
    E getFront();
    int getSize();
    boolean isEmpty();
}
