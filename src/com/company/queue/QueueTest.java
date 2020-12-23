package com.company.queue;

/**
 * 功能描述: <br>
 * <p>〈〉</p>
 *
 * @author Joker
 * @ClassName QueueTest
 * @date 2020/12/23 9:46
 * @Version 1.0
 * @ReviseName:
 * @ReviseTime: 2020/12/23 9:46
 */
public class QueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        Integer front = queue.getFront();
        System.out.println(front);
    }
}
