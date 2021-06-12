package com.leetcode.Sort;

/**
 * Created with IntelliJ IDEA
 * Project: 冒泡排序 [2,1,5,4,6]  小->大
 * Author: jingren
 * Date: 2021/3/21
 * Time: 4:20 PM
 */
public class BubbleSort {

    public void sort(int[] nums) {
        int temp = 0;
        for (int i = 1; i < nums.length; i++) { //循环趟数：n-1趟，因为最后剩下一个必然已经有序，不用排
            for (int j = 0; j < nums.length - 1 - i; j++) { //从第一个数开始，两两之间进行比较，完成一趟，则把最大的数放到了末尾
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    //改进冒泡排序
    public void sort2(int[] nums) {
        int temp = 0;
        boolean swap = false;
        for (int i = 1; i < nums.length; i++) { //循环趟数：n-1趟，因为最后剩下一个必然已经有序，不用排

            swap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) { //从第一个数开始，两两之间进行比较，完成一趟，则把最大的数放到了末尾
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) { //在每一趟排序结束后都判断一下这个过程中是否存在交互，如果没有交换，则说明都已经有序了，后面不用再比较了
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 4, 6};
        BubbleSort b = new BubbleSort();
        b.sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
