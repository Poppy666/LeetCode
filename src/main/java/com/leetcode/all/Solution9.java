package com.leetcode.all;

/**
 * Created with IntelliJ IDEA
 * Project: 如果不明白始终把最小值往最大值方向移动不会错过最大体积，可参考
 * https://leetcode.com/problems/container-with-most-water/discuss/6099/Yet-another-way-to-see-what-happens-in-the-O(n)-algorithm
 * Author: jingren
 * Date: 2019/9/15
 * Time: 下午5:11
 */
public class Solution9 {
    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
