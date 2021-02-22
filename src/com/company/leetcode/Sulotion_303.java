package com.company.leetcode;

/**
 * @version 1.0.0
 * @ClassName Sulotion_303.java
 * @Package com.company.leetcode
 * @Author Joker
 * @Description 区域和检索
 * @CreateTime 2021年02月02日 14:15:00
 */
public class Sulotion_303 {
    private interface Merger<E> {

        E merge(E a, E b);
    }
    private class SegmentTree<E> {
        private final E[] tree;
        private final E[] data;
        private final Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {
            this.merger = merger;
            this.data = (E[]) new Object[arr.length];
            System.arraycopy(arr, 0, data, 0, arr.length);
            tree = (E[]) new Object[4 * arr.length];
            buildSegmentTree(0, 0, data.length - 1);
        }


        /**
         * 方法描述: <br>
         * <p> 在treeIndex的位置创建表示区间[l......r]的线段树 </p>
         *
         * @param treeIndex 节电
         * @param l         左边界
         * @param r         右边界
         * @return void
         * @Author Joker
         * @CreateDate 2021/2/2 10:25
         * @ReviseName
         * @ReviseTime 2021/2/2 10:25
         **/
        private void buildSegmentTree(int treeIndex, int l, int r) {
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            int mid = l + (r - l) / 2;

            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

        }

        /**
         * 方法描述: <br>
         * <p> 返回区间[queryL....queryR] 的值 </p>
         *
         * @param queryL
         * @param queryR
         * @return E
         * @Author Joker
         * @CreateDate 2021/2/2 13:34
         * @ReviseName
         * @ReviseTime 2021/2/2 13:34
         **/
        public E query(int queryL, int queryR) {
            if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("Index is illegal");
            }
            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /**
         * 方法描述: <br>
         * <p> 在以treeIndex为根的线段树中[l~r]的范围内，搜索区间为[queryL~queryR]的值 </p>
         *
         * @param treeIndex 根
         * @param l
         * @param r
         * @param queryL
         * @param queryR
         * @return E
         * @Author Joker
         * @CreateDate 2021/2/2 13:35
         * @ReviseName
         * @ReviseTime 2021/2/2 13:35
         **/
        public E query(int treeIndex, int l, int r, int queryL, int queryR) {
            if (queryL == l && queryR == r) {
                return tree[treeIndex];
            }

            int mid = l + (r - l) / 2;

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (queryR <= mid ) {
                return query(leftTreeIndex,l, mid,queryL,queryR);
            } else if (queryL >= mid + 1) {
                return query(rightTreeIndex,mid + 1 ,r , queryL,queryR);
            }
            E queryLeft = query(leftTreeIndex, l, mid , queryL, queryR);
            E queryRight = query(rightTreeIndex, mid +1, r, queryL, queryR);
            return merger.merge(queryLeft,queryRight);


        }

        /**
         * 方法描述: <br>
         * <p> 获取元素个数 </p>
         *
         * @param
         * @return int
         * @Author Joker
         * @CreateDate 2021/2/2 10:14
         * @ReviseName
         * @ReviseTime 2021/2/2 10:14
         **/
        public int getSize() {
            return data.length;
        }

        /**
         * 方法描述: <br>
         * <p> 获取index位置的值 </p>
         *
         * @param index 指定位置
         * @return E
         * @Author Joker
         * @CreateDate 2021/2/2 10:16
         * @ReviseName
         * @ReviseTime 2021/2/2 10:16
         **/
        public E get(int index) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("Index is illegal");
            }
            return data[index];
        }

        /**
         * 方法描述: <br>
         * <p> 获取左孩子的索引值 </p>
         *
         * @param index 指定位置
         * @return int
         * @Author Joker
         * @CreateDate 2021/2/2 10:17
         * @ReviseName
         * @ReviseTime 2021/2/2 10:17
         **/
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        /**
         * 方法描述: <br>
         * <p> 获取右孩子索引值 </p>
         *
         * @param index 指定位置
         * @return int
         * @Author Joker
         * @CreateDate 2021/2/2 10:17
         * @ReviseName
         * @ReviseTime 2021/2/2 10:17
         **/
        private int rightChild(int index) {
            return 2 * index + 2;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] != null) {
                    stringBuilder.append(tree[i]);
                } else {
                    stringBuilder.append("null");
                }
                if (i != tree.length - 1) {
                    stringBuilder.append("->");
                }
            }
            stringBuilder.append("]");

            return stringBuilder.toString();
        }
    }
    SegmentTree<Integer> segmentTree;
    public Sulotion_303(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, Integer::sum);
        }

    }

    public int sumRange(int i, int j) {
        if (segmentTree != null) {
            return segmentTree.query(i,j);
        } else {
            throw new IllegalArgumentException("segmentTree is null");
        }
    }
}
