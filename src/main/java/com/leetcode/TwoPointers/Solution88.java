package com.leetcode.TwoPointers;

/**
 * Created with IntelliJ IDEA
 * Project: 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3   1,2,3   3,5,6
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * 思路：从后往前遍历，从前往后的话需要额外的空间
 * Author: jingren
 * Date: 2020/5/31
 * Time: 8:18 PM
 */
public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n <= 0) {
            return;
        }

        int p = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            nums1[p--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while (i >= 0 && j == -1) {   //注意这里的边界条件，其中一个数组遍历到头时，这时的坐标已经变成了-1
            nums1[p--] = nums1[i--];
        }
        while (j >= 0 && i == -1) {
            nums1[p--] = nums2[j--];
        }

    }


}
