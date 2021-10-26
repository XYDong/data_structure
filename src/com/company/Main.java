package com.company;

import com.company.array.Array;
import com.company.queue.ArrayQueue;
import com.company.queue.LoopQueue;
import com.company.queue.Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Main {

//    public static void main(String[] args) {
//	// write your code here
//        Array<Integer> array = new Array<>();
//        for (int i = 0; i < 10; i++) {
//            array.addLast(i);
//        }
//        System.out.println(array.toString());
//        array.add(1,100);
//        System.out.println(array);
//        array.add(1,-1);
//        System.out.println(array);
//        array.remove(2);
//        System.out.println(array);
//        array.removeElement(2);
//        System.out.println(array);
//    }

    public static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        // ....
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        double v = testQueue(queue, opCount);
        System.out.println(String.format("ArrayQueue 耗时： %f 秒",v));
        LoopQueue<Integer> queue2 = new LoopQueue<>();
        double v1 = testQueue(queue2, opCount);
        System.out.println(String.format("LoopQueue 耗时： %f 秒",v1));

    }
}
