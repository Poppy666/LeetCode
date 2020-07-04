package com.leetcode.TwoPointers;

/**
 * Created with IntelliJ IDEA
 * Project: 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 思路：用两个指针分别指向数组的首尾，向中间遍历，首尾两数之和小于目标值，则头指针向后移动，否则尾指针向前移动
 * Author: jingren
 * Date: 2020/6/29
 * Time: 上午9:46
 */
public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
        }
        return result;
    }

}
