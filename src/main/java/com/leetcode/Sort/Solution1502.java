package com.leetcode.Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Project: 1502. 判断能否形成等差数列
 * Author: jingren
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 * Date: 2020/10/16
 * Time: 上午9:48
 */
public class Solution1502 {

    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
