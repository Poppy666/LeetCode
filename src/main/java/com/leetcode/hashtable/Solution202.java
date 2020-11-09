package com.leetcode.hashtable;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA
 * Project: 202. 快乐数
 * Author: jingren
 * Date: 2020/11/4
 * Time: 9:45 PM
 */
public class Solution202 {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    private int getSum(int n){
        int sum = 0;
        while (n > 0) {
            int m = n % 10;
            n /= 10;
            sum +=m*m;
        }
        return sum;
    }

    public boolean isHappy_2(int n) {
        int slow = n;
        int fast = getSum(n);
        while (fast!=1 && slow!=fast){
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return fast == 1;

    }
}
