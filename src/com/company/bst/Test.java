package com.company.bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @version 1.0.0
 * @ClassName Test.java
 * @Package com.company.bst
 * @Author Joker
 * @Description 测试二分搜索树
 * @CreateTime 2021年01月12日 14:49:00
 */
public class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        int[] nums = {5,3,6,8,4,2};
//        for (int num : nums) {
//            bst.add(num);
//        }
//        bst.preOrder();
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println();
//        bst.preOrderQ();
//        System.out.println();

//        System.out.println(bst.toString());

//        bst.inOrder();
//        System.out.println();

        Random random = new Random();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1) > nums.get(i)) {
                throw new IllegalArgumentException("Erro");
            }
        }
        System.out.println("removeMin test successful");


    }
}
