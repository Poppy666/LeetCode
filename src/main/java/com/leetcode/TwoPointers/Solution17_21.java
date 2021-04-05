package com.leetcode.TwoPointers;

/**
 * Created with IntelliJ IDEA
 * Project: 面试题 17.21 直方图的水量
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 思路：对于每列而言，只有当前列的值小于左边的最大值和右边的最大值中的较小值时才可能蓄水。因此每次蓄水需要从最大值较小的一边进行移动，不断更新最大高度
 * 每移动一次的蓄水增量=当前高度-历史最大高度，因此如果当前高度小于历史高度，则差值为负，表明无法蓄水，因为蓄水增量为0
 * 1.用最左和最右两个指针不断向中间移动，进行储水，不断更新最大高度
 * 2.最leftmax和rightmax分别记录左边和右边的最大高度
 * Author: jingren
 * Date: 2020/4/2
 * Time: 上午9:33
 */
public class Solution17_21 {

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftmax = height[left];
        int rightmax = height[right];

        int res = 0;
        while (left < right) {
            if (leftmax < rightmax) {
                res += Math.max(leftmax - height[++left], 0);
                leftmax = Math.max(leftmax, height[left]);
            } else {
                res += Math.max(rightmax - height[--right], 0);
                rightmax = Math.max(rightmax, height[right]);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Solution17_21 solution = new Solution17_21();
        System.out.println(solution.trap(height));
    }

}
