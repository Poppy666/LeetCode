package com.leetcode.Sort;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA
 * Project: 快速排序 [2,1,5,4,6]
 * Author: jingren
 * Date: 2021/3/21
 * Time: 4:55 PM
 */
public class QuickSort {

    public void sort(int[] nums) {
        if (nums.length > 0) {
            quickSort(nums, 0, nums.length - 1);
        }
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int middle = getMiddle(nums, low, high);
            quickSort(nums, low, middle-1);
            quickSort(nums, middle + 1, high);
        }
    }

    //找一个基准数，然后来回两头进行比较，小的放左边，大的放右边，比较完后的结果是，该元素把数组分成了两部分，一部分比他小的，一部分比他大的
    public int getMiddle(int[] nums, int low, int high) {
        int temp = nums[low]; //假设最左边的为基准
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high]; //比基准数小，则交换

            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];

        }
        nums[low] = temp;
        return low;
    }

    //法二：
    public void sort2(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int low = 0;
        int high = nums.length - 1;
        int temp = nums[0];
        int t;
        while (low < high) {
            while (low < high && temp <= nums[high]) {
                high--;
            }
            while (low < high && temp >= nums[low]) {
                low++;
            }
            if (low < high) {
                t = nums[low];
                nums[low] = nums[high];
                nums[high] = t;
            }
        }
        nums[low]= nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
        QuickSort b = new QuickSort();
        b.sort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
