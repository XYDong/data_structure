package com.company.sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @version 1.0.0
 * @ClassName SortTest.java
 * @Package com.company.sort
 * @Author Joker
 * @Description 冒泡排序
 * @CreateTime 2021年03月15日 09:38:00
 */
public class SortTest {
    public static void main(String[] args) {
        int[] data = new int[]{5,22,8,10,16,33,1,9,27,13};
//        System.out.println("冒泡排序：" + Arrays.toString(bubbleSort(data)));
//        System.out.println("---------------------------------------");
//        System.out.println("选择排序：" + Arrays.toString(selectSort(data)));
//        System.out.println("---------------------------------------");
//        System.out.println("插入排序：" + Arrays.toString(insertSort(data)));
//        System.out.println("---------------------------------------");
//        System.out.println("希尔排序：" + Arrays.toString(hillSort(data)));
//        System.out.println("---------------------------------------");
//        System.out.println("快速排序：" + Arrays.toString(quickSort(data)));
//        System.out.println("---------------------------------------");
        HashMap<Integer,String> map = new HashMap<>();
        int size = map.size();
        System.out.println("map size = " + size);
        map.put(1,"123");
//        TestClass1 testClass1 = new TestClass1();
    }

    /**
     * 冒泡排序
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 0; i1 < nums.length - i - 1; i1++) {
                if (nums[i1 + 1] < nums[i1]) {
                    int temp = nums[i1 + 1];
                    nums[i1 + 1] = nums[i1];
                    nums[i1] = temp;
                }
            }
        }
        return nums;
    }
    /**
     * 选择排序
     * @param nums
     * @return
     */
    public static int[] selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i +1 ; i1 < nums.length; i1++) {
                if (nums[i] > nums[i1]) {
                    int temp = nums[i1];
                    nums[i1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }
    
    /**
     * 方法描述: <br>
     * <p> 插入排序 </p>
     *
     * @Author Joker
     * @CreateDate 2021/3/15 10:06
     * @param nums
     * @return int
     * @ReviseName 
     * @ReviseTime 2021/3/15 10:06
     **/
    public static int[] insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j -1] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    /**
     * 希尔排序
     * @param nums
     * @return
     */
    public static int[] hillSort(int[] nums){
        for (int i = nums.length / 2 ; i > 0; i /= 2) {
            for (int j = i ; j < nums.length; j++) {
                for (int k = j ; k > 0 && k - i >= 0; k -= i) {
                    if (nums[k] > nums[k -i]) {
                        int temp = nums[k - i];
                        nums[k - i ] = nums[k];
                        nums[k] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        return nums;
    }

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public static int[] quickSort(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        quickSort(nums, low, high);
        return nums;
    }

    private static void quickSort(int[] nums, int low, int high) {
        //如果指针在同一位置(只有一个数据时)，退出
        if (high - low < 1) {
            return;
        }
        //标记，从高指针开始，还是低指针（默认高指针）
        boolean flag = true;
        //记录指针的其实位置
        int start = low;
        int end = high;
        int midValue = nums[low];
        while (true) {
            if (flag) {
                if (nums[high] > midValue) {
                    high--;
                } else if (nums[high] < midValue) {
                    nums[low] = nums[high];
                    low ++;
                    flag = false;
                }
            } else {
                if (nums[low] < midValue) {
                    low ++;
                } else if (nums[low] > midValue) {
                    nums[high] = nums[low];
                    high--;
                    flag = true;
                }
            }
            if (low == high) {
                nums[low] = midValue;
                break;
            }
        }
        quickSort(nums,start,low - 1);
        quickSort(nums,low + 1,end);

    }


}
