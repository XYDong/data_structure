package com.company.stack;

/**
 * 功能描述: <br>
 * <p>〈栈操作〉</p>
 *
 * @author Joker
 * @ClassName Stack
 * @date 2020/12/22 14:03
 * @Version 1.0
 * @ReviseName:
 * @ReviseTime: 2020/12/22 14:03
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();

    /**
     * 添加
     * @param e
     */
    void push(E e);

    /**
     * 取出最后一个
     * @return
     */
    E pop();

    /**
     * 去除最后一个元素
     * @return
     */
    E peek();
}
