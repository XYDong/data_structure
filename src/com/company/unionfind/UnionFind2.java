package com.company.unionfind;

/**
 * @version 1.0.0
 * @ClassName UnionFind2.java
 * @Package com.company.unionfind
 * @Author Joker
 * @Description 第二个版本
 * @CreateTime 2021年02月24日 09:10:00
 */
public class UnionFind2 implements UF{
    private int[] parent;

    public UnionFind2(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找过程，查找元素p所对应的集合编号
     * O(h) 复杂度，h为树的高度
     * @param p 需要查找的元素
     * @return int
     */
    private int find(int p) {
        if ( p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
    }
}
