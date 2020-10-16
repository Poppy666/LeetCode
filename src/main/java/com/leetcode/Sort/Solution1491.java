package com.leetcode.Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Project: 1491. 去掉最低工资和最高工资后的工资平均值
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * Author: jingren
 * Date: 2020/10/16
 * Time: 上午9:46
 */
public class Solution1491 {

    public double average(int[] salary) {
        if (salary.length < 3) {
            return 0;
        }
        Arrays.sort(salary);
        double sum = 0;
        for (int s : salary) {
            sum += s;
        }
        return (sum - salary[0] - salary[salary.length - 1]) / (salary.length - 2);
    }
}
