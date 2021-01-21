package com.company.map;

/**
 * @version 1.0.0
 * @ClassName Map.java
 * @Package com.company.map
 * @Author Joker
 * @Description 映射接口
 * @CreateTime 2021年01月21日 09:18:00
 */
public interface Map<K, V> {
    /**
     * 方法描述: <br>
     * <p> 获取元素个数 </p>
     *
     * @return int
     * @Author Joker
     * @CreateDate 2021/1/21 9:20
     * @ReviseName
     * @ReviseTime 2021/1/21 9:20
     **/
    int getSize();

    /**
     * 方法描述: <br>
     * <p> 是否为空 </p>
     *
     * @return boolean
     * @Author Joker
     * @CreateDate 2021/1/21 9:22
     * @ReviseName
     * @ReviseTime 2021/1/21 9:22
     **/
    boolean isEmpty();

    /**
     * 方法描述: <br>
     * <p> 该映射中是否包含key </p>
     *
     * @param key 键
     * @return boolean
     * @Author Joker
     * @CreateDate 2021/1/21 9:26
     * @ReviseName
     * @ReviseTime 2021/1/21 9:26
     **/
    boolean contains(K key);

    /**
     * 方法描述: <br>
     * <p> 获取键对应的值 </p>
     *
     * @param key 键
     * @return V
     * @Author Joker
     * @CreateDate 2021/1/21 9:31
     * @ReviseName
     * @ReviseTime 2021/1/21 9:31
     **/
    V getValue(K key);

    /**
     * 方法描述: <br>
     * <p> 给对应的Key设置新值 </p>
     *
     * @param key 键
     * @param value 值
     * @return void
     * @Author Joker
     * @CreateDate 2021/1/21 9:43
     * @ReviseName
     * @ReviseTime 2021/1/21 9:43
     **/
    void setValue(K key, V value);

    /**
     * 方法描述: <br>
     * <p> 添加元素 </p>
     *
     * @param key   键
     * @param value 值
     * @return void
     * @Author Joker
     * @CreateDate 2021/1/21 9:23
     * @ReviseName
     * @ReviseTime 2021/1/21 9:23
     **/
    void add(K key, V value);

    /**
     * 方法描述: <br>
     * <p> 删除Key下边存储的value </p>
     *
     * @param key 键
     * @return V
     * @Author Joker
     * @CreateDate 2021/1/21 9:29
     * @ReviseName
     * @ReviseTime 2021/1/21 9:29
     **/
    V remove(K key);


}
