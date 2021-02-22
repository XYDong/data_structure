package com.company.segmenttree;

/**
 * @version 1.0.0
 * @ClassName Merger.java
 * @Package com.company.segmenttree
 * @Author Joker
 * @Description 数据合并
 * @CreateTime 2021年02月02日 10:33:00
 */
public interface Merger<E> {

    E merge(E a, E b);
}
