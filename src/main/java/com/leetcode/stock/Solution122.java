package com.leetcode.stock;

/**
 * Created with IntelliJ IDEA
 * Project: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 7
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

 思路：画图法。画出折线图后，可以看出多次交易的利润绝对比一次交易大，因此记录每次的买点，更新利润即可


 * Author: jingren
 * Date: 2020/11/10
 */
public class Solution122 {

    public int maxProfit(int[] prices) {
        int result = 0;
        int curr = Integer.MAX_VALUE; //记录买点
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > curr) {
                result += prices[i] - curr;
            }
            curr = prices[i];
        }
        return result;
    }

    //遍历整个股票交易日价格列表 price，策略是所有上涨交易日都买卖（赚到所有利润），所有下降交易日都不买卖（永不亏钱）。
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
    }

}
