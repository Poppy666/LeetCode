package com.leetcode.Sort;

/**
 * Created with IntelliJ IDEA
 * Project: 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * Author: jingren
 * Date: 2020/9/16
 * Time: 下午3:38
 */
public class Solution922 {

    public int[] sortArrayByParityII(int[] A) {

        int j = 1;
        for (int i = 0; i < A.length - 1; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;

//        int i = 0;
//        while (i < A.length-1) {
//            if (A[i] % 2 != i % 2) {
//                int j = i + 1;
//                while (j < A.length && (A[j] % 2 == j % 2 || j % 2 != i % 2)) {
//                    j++;
//                }
//                swap(A, i, j);
//            }
//            i++;
//        }

    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
