package com.company.queue;

/**
 * 功能描述: <br>
 * <p>〈〉</p>
 *
 * @author Joker
 * @ClassName LoopQueueTest
 * @date 2020/12/23 10:59
 * @Version 1.0
 * @ReviseName:
 * @ReviseTime: 2020/12/23 10:59
 */
public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        Integer front = queue.getFront();
        System.out.println(front);
    }
}
