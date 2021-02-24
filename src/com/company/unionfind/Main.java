package com.company.unionfind;

import java.util.Random;

/**
 * @version 1.0.0
 * @ClassName Main.java
 * @Package com.company.unionfind
 * @Author Joker
 * @Description 测试类
 * @CreateTime 2021年02月24日 09:30:00
 */
public class Main {
    public static double test(UF uf, int m) {
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            Random random = new Random();
            uf.unionElements(random.nextInt(uf.getSize()),random.nextInt(uf.getSize()));
        }
        for (int i = 0; i < m; i++) {
            Random random = new Random();
            uf.isConnected(random.nextInt(uf.getSize()),random.nextInt(uf.getSize()));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 100000;
        int m = 100000;
        UnionFind1 uf1 = new UnionFind1(size);
        System.out.println("UnionFind1 : " + test(uf1,m) + "s");
        UnionFind2 uf2 = new UnionFind2(size);
        System.out.println("UnionFind2 : " + test(uf2,m) + "s");
        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3 : " + test(uf3,m) + "s");
    }

}
