package com.company.sort;

/**
 * @version 1.0.0
 * @ClassName TestClass1.java
 * @Package com.company.sort
 * @Author Joker
 * @Description 测试类
 * @CreateTime 2021年03月16日 10:26:00
 */
public class TestClass1 {

    private boolean flag;
    private int num = 0;

    public TestClass1() {
        this.num = 2;
    }

    public TestClass1(int num) {
        this(num,false);
    }

    public TestClass1(int num, boolean b) {
        this.num = num;
        this.flag = b;
    }
}
