package com.company.leetcode;

import com.company.array.Array;

import java.util.*;

/**
 * @version 1.0.0
 * @ClassName solution_347.java
 * @Package com.company.leetcode
 * @Author Joker
 * @Description
 * @CreateTime 2021年02月01日 09:50:00
 */
public class solution_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num,map.getOrDefault(num,0) + 1);
            } else {
                map.put(num,1);
            }
        }
        int[] res = new int[k];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (priorityQueue.size() == k) {
                assert priorityQueue.peek() != null;
                if (priorityQueue.peek()[1] < count) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{num,count});
                }
            } else {
                priorityQueue.offer(new int[]{num,count});
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        System.out.println(ints);
    }
}
