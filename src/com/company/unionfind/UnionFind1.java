package com.company.unionfind;

/**
 * @version 1.0.0
 * @ClassName UnionFind.java
 * @Package com.company.unionfind
 * @Author Joker
 * @Description 并查集
 * @CreateTime 2021年02月22日 13:53:00
 */
public class UnionFind1 implements UF{
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 方法描述: <br>
     * <p> 查找元素p所对应的集合编号 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/22 15:12
     * @param p
     * @return int
     * @ReviseName
     * @ReviseTime 2021/2/22 15:12
     **/
    private int find(int p){
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
          return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
}
