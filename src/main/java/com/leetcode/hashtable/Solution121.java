package com.leetcode.hashtable;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Project: 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

 注意：你不能在买入股票前卖出股票。

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。



 * Author: jingren
 * Date: 2020/11/9
 * Time: 10:00 PM
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        Stack<Integer> stack = new Stack<>();  //记录当前最小值
        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty()) {
                stack.push(prices[i]);
            }else {
                Integer curr = stack.peek();
                if (prices[i] < curr) {
                    stack.push(prices[i]);
                } else {
                    maxPrice = Math.max(maxPrice, prices[i] - curr);
                }
            }
        }
        return maxPrice;
    }


    public int maxProfit_2(int[] prices) {
        if(prices.length==0 || prices.length==1){
            return 0;
        }
        int maxPrice = 0;
        int currMin = prices[0];  //记录当前最小值
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currMin) {
                currMin = prices[i];
            } else if (prices[i] > currMin) {
                maxPrice = Math.max(maxPrice, prices[i] - currMin);
            }
        }
        return maxPrice;
    }
}
