package com.leetcode.all;

/**
 * Created with IntelliJ IDEA
 * Project:
 * Author: jingren
 * Date: 2019/9/5
 * Time: 下午7:37
 */
public class Solution8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }

    public static int myAtoi(String str) {
        String s = str.trim();
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int sign = 1;
        int start = 0;
        char firstChar = s.charAt(0);
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        } else if (!Character.isDigit(firstChar)) {
            return 0;
        }
        long result = 0;
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return (int) (result * sign);
            result = result * 10 + s.charAt(i) - '0';
            if (result > Integer.MAX_VALUE && sign == 1) {
                return Integer.MAX_VALUE;

            }
            if (result > Integer.MAX_VALUE && sign == -1) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (result * sign);
    }

}
