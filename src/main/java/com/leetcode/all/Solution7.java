package com.leetcode.all;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2019/8/29
 * Time: 下午8:02
 */
public class Solution7 {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }
}
