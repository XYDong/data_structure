package com.company.maxheap;

import java.util.Random;

/**
 * @version 1.0.0
 * @ClassName Main.java
 * @Package com.company.maxheap
 * @Author Joker
 * @Description 测试类
 * @CreateTime 2021年01月25日 11:02:00
 */
public class Main {

    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i = n; i > 0; i--) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i -1]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test maxHeap complete.");
    }
}
