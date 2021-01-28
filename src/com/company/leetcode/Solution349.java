package com.company.leetcode;

import java.util.TreeSet;

/**
 * @version 1.0.0
 * @ClassName Solution349.java
 * @Package com.company.leetcode
 * @Author Joker
 * @Description 两个数组的交集
 * @CreateTime 2021年01月25日 09:34:00
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
            }
        }
        return null;
    }
}
