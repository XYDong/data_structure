package com.company.leetcode;

/**
 * @version 1.0.0
 * @ClassName Sum.java
 * @Package com.company.leetcode
 * @Author Joker
 * @Description 递归算法入门
 * @CreateTime 2021年01月11日 10:42:00
 */
public class Sum {
    public static int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr,int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + sum(arr, index + 1);
    }

    public static void main(String[] args) {
        int sum = sum(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("sum arr = " + sum);
    }
}
