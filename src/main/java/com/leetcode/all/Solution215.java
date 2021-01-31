package com.leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4

 说明:
 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * Author: jingren
 * Date: 2021/1/25
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = nums.length; i >= 0; i--) {
            if (i == nums.length - k) {
                return nums[i];
            }
        }
        return 0;

    }


}
