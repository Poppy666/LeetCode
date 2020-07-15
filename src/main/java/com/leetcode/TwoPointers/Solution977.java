package com.leetcode.TwoPointers;

/**
 * Created with IntelliJ IDEA
 * Project: 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 思路：用两个指针分别从最左和最右向中间遍历，比较元素的绝对值，把[较大的值]存到结果数组的最后一个
 * 时间复杂度：O(n),空间复杂度O(n)
 * 是否还需要考虑平方的结果会溢出
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * Author: jingren
 * Date: 2020/7/13
 * Time: 上午9:44
 */
public class Solution977 {
    public int[] sortedSquares(int[] A) {
        if (A == null) {
            return null;
        }
        int left = 0;
        int right = A.length - 1;
        int[] result = new int[A.length];
        int i = A.length-1;
        while (left <= right ) {
            if (Math.pow(A[left], 2) <= Math.pow(A[right], 2)) {
                result[i] = (int) Math.pow(A[right], 2);
                right--;
                i--;
            } else {
                result[i] = (int) Math.pow(A[left], 2);
                left++;
                i--;
            }
        }
        return result;
    }

}
