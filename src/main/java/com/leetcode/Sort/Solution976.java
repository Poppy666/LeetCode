package com.leetcode.Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Project: 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * 输入：[2,1,2]
 * 输出：5
 * <p>
 * 输入：[1,2,1]
 * 输出：0
 *
 * 示例 3：
 * 输入：[3,2,3,4]  2334
 * 输出：10
 * 思路：将数组进行排序，固定最大值，寻找能组成三角形的剩余两条边，由于取的是最大周长，剩余两条边必然是次小的那两个数
 * Author: jingren
 * Date: 2020/9/18
 * Time: 上午9:57
 */
public class Solution976 {

    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }

        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
