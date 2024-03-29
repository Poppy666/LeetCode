package com.leetcode.stock;

/**
 * Created with IntelliJ IDEA
 * Project: 714. 买卖股票的最佳时机含手续费
 *
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

 返回获得利润的最大值。

 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 输出: 8
 解释: 能够达到的最大利润:
 在此处买入 prices[0] = 1
 在此处卖出 prices[3] = 8
 在此处买入 prices[4] = 4
 在此处卖出 prices[5] = 9
 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * Author: jingren
 * Date: 2020/12/17
 */
public class Solution714 {

    public int maxProfit(int[] prices, int fee) {
        //动态规划
        //dp[i,0],第i天不持有股票的收益
        //dp[i,1],第i天持有股票的收益
        // int[][] dp = new int[prices.length][2];
        // dp[0][0]=0;
        // dp[0][1]=-prices[0];
        // for(int i=1;i<prices.length;i++){
        //     dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
        //     dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        // }
        // return dp[prices.length-1][0];

        //节省空间的动态规划
        int sold=0;
        int buy=-prices[0];
        for(int i=1;i<prices.length;i++){
            sold=Math.max(sold,buy+prices[i]-fee);
            buy=Math.max(sold-prices[i],buy);
        }
        return sold;

        // //贪心算法：当我们卖出一支股票时，我们就立即获得了以相同价格并且免除手续费买入一支股票的权利。
        // int profit = 0;
        // int cost = prices[0]+fee;
        // for(int i=1;i<prices.length;i++){
        //     if(prices[i]+fee<cost){
        //         cost = prices[i]+fee;
        //     }else if(prices[i]>cost){
        //         profit+=prices[i]-cost;
        //         cost = prices[i];
        //     }
        // }
        // return profit;

    }
}
