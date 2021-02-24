package com.company.unionfind;

/**
 * @version 1.0.0
 * @ClassName UF.java
 * @Package com.company.unionfind
 * @Author Joker
 * @Description 并查集接口
 * @CreateTime 2021年02月22日 13:54:00
 */
public interface UF {

    /**
     * 方法描述: <br>
     * <p> 获取元素个数 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/23 16:04
     * @param 
     * @return int
     * @ReviseName 
     * @ReviseTime 2021/2/23 16:04
     **/
    int getSize();
    /**
     * 方法描述: <br>
     * <p> 查询两个元素是否连接（是否属于一个集合） </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/22 13:55
     * @param p
     * @param q
     * @return boolean
     * @ReviseName
     * @ReviseTime 2021/2/22 13:55
     **/
    boolean isConnected(int p , int q);

    /**
     * 方法描述: <br>
     * <p> 合并 </p>
     *
     * @Author Joker
     * @CreateDate 2021/2/22 13:57
     * @param p
     * @param q
     * @return void
     * @ReviseName
     * @ReviseTime 2021/2/22 13:57
     **/
    void unionElements(int p, int q);
}
