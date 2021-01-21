package com.company.set;

/**
 * @version 1.0.0
 * @ClassName Set.java
 * @Package com.company.set
 * @Author Joker
 * @Description 集合接口
 * @CreateTime 2021年01月19日 15:40:00
 */
public interface Set<E> {
    /**
     * 方法描述: <br>
     * <p> 添加元素 </p>
     *
     * @Author Joker
     * @CreateDate 2021/1/19 15:44
     * @param e
     * @return void
     * @ReviseName 
     * @ReviseTime 2021/1/19 15:44
     **/
    void add(E e);
    /**
     * 方法描述: <br>
     * <p> 删除元素 </p>
     *
     * @Author Joker
     * @CreateDate 2021/1/19 15:44
     * @param e
     * @return void
     * @ReviseName 
     * @ReviseTime 2021/1/19 15:44
     **/
    void remove(E e);
    /**
     * 方法描述: <br>
     * <p> 判断是否包含元素 </p>
     *
     * @Author Joker
     * @CreateDate 2021/1/19 15:44
     * @param e
     * @return boolean
     * @ReviseName 
     * @ReviseTime 2021/1/19 15:44
     **/
    boolean contains(E e);
    /**
     * 方法描述: <br>
     * <p> 获取元素个数 </p>
     *
     * @Author Joker
     * @CreateDate 2021/1/19 15:45
     * @param 
     * @return int
     * @ReviseName 
     * @ReviseTime 2021/1/19 15:45
     **/
    int getSize();
    /**
     * 方法描述: <br>
     * <p> 集合是否为空 </p>
     *
     * @Author Joker
     * @CreateDate 2021/1/19 15:49
     * @param 
     * @return boolean
     * @ReviseName 
     * @ReviseTime 2021/1/19 15:49
     **/
    boolean isEmpty();

}
