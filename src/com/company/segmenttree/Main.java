package com.company.segmenttree;

/**
 * @version 1.0.0
 * @ClassName Main.java
 * @Package com.company.segmenttree
 * @Author Joker
 * @Description 测试线段树
 * @CreateTime 2021年02月02日 10:38:00
 */
public class Main {
    public static void main(String[] args) {

        Integer[] nums = new Integer[]{-2,0,3,-5,2,-1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree.toString());

        System.out.println(segmentTree.query(0,2));

    }
}
