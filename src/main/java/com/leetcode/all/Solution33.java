package com.leetcode.all;

/**
 * Created with IntelliJ IDEA
 * Project: 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 思路：如果数组是严格有序的，毫无疑问，直接用二分法。但是这里不是严格有序的，仍然可以用二分法，因此把数组从中间分成两部分，其中一部分一定是有序的
 * 则对这部分有序的可以用二分法，不断进行下去，一定会找到目标元素
 * <p>
 * Author: jingren
 * Date: 2021/5/18
 */
public class Solution33 {

    public int search(int[] nums, int target) {

        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[0]) { //注意两个条件需同时满足
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }
        return -1;
    }
}
