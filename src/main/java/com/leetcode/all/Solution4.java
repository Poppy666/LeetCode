package com.leetcode.all;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2019/8/25
 * Time: 下午4:15
 */
public class Solution4 {
    public static void main(String[] args) {
        int[] nums1 = new int[1];
        nums1[0] = 1;
        int[] nums2 = new int[3];
        nums2[0] = 2;
        nums2[1] = 3;
        nums2[2] = 4;
        double result = findMedianSortedArrays(nums1, nums2);
    }

    //我的思路：分别用两个指针指向两个数组的开始，依次比较，把较小的数字放到num集合数组中去，最后取num的中位数
    //需要注意的是边界情况的考虑
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m <= 0) {
            if (n % 2 == 1) {
                return nums2[n / 2];
            }
            return (nums2[(n - 1) / 2] + nums2[n / 2]) / 2.0;
        }
        if (n <= 0) {
            if (m % 2 == 1) {
                return nums1[m / 2];
            }
            return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
        }
        int i = 0, j = 0;
        int num[] = new int[m + n];
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        while (i == m && j < n) {
            num[k++] = nums2[j++];
        }
        while (j == n && i < m) {
            num[k++] = nums1[i++];
        }
        if ((m + n) % 2 == 1) {
            return num[(m + n) / 2];
        } else {
            return (num[(m + n - 1) / 2] + num[(m + n) / 2]) / 2.0;
        }
    }
}
