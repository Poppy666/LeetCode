package com.leetcode.Sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Project: 非递增顺序的最小子序列
 * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
 * 注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
 *
 * 输入：nums = [4,4,7,6,7]   2 3 3 6 7 7
 * 输出：[7,7,6]
 * 解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，元素按非递增顺序返回。
 * Author: jingren
 * Date: 2020/4/12
 * Time: 4:04 PM
 */
public class Solution1403 {

    public List<Integer> minSubsequence(int[] nums) {
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();

        int subSum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            subSum += nums[i];
            if (subSum > sum - subSum) {
                result.add(nums[i]);
                break;
            } else {
                result.add(nums[i]);
            }

        }
        return result;

    }

}
