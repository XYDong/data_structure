package com.company.other;

/**
 * @version 1.0.0
 * @ClassName PreAndPostPlusDemo.java
 * @Package com.company.other
 * @Author Joker
 * @Description ++1 和 1++ 的区别
 * @CreateTime 2021年03月10日 16:31:00
 */
public class PreAndPostPlusDemo {
    public static void main(String[] args) {
        int i = 15;
        prePlus1(i);
        prePlus2(i);
        prePlus3(i);
        prePlus4(i);
    }

    private static void prePlus1(int i) {
        System.out.println("prePlus1111:i=" + i );
        int j = ++i;
        System.out.println("prePlus1:i=" + i + ",j=" + j);
        System.out.println("prePlus1111111: i + j = " + (i + j) );
    }

    private static void prePlus2(int i) {
        i = ++i;
        System.out.println("prePlus2:i=" + i);
    }

    private static void prePlus3(int i) {
        int j = i++;
        System.out.println("prePlus3:i=" + i + ",j=" + j);
        System.out.println("prePlus333: i + j = " + (i + j) );
    }

    private static void prePlus4(int i) {
        i = i++;
        System.out.println("prePlus4:i=" + i);
    }
}
