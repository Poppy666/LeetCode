package com.leetcode.stock;

/**
 * Created with IntelliJ IDEA
 * Project: 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 思路：参考https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/cong-zuo-dao-you-zai-cong-you-dao-zuo-sao-liang-bi/
 f[i]记录以0 ~ i中的最低价MIN买入，当前价prices[i]卖出的利润，因此f[i]=prices[i] - MIN
 再从右到左扫一遍，求出i ~ n-1区间内最大利润value = max{最大卖出价MAX - 买入价}
 那么最终结果ans=max{f[i-1]+value}

 * Author: jingren
 * Date: 2021/4/5
 */
public class Solution123 {

    public int maxProfit(int[] prices) {

        int f[] = new int[prices.length]; // f[i]记录以0 ~ i中的最低价MIN买入，当前价prices[i]卖出的利润
        int min = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]< min){
                min = prices[i];
            }
            f[i]= prices[i]-min;
        }
        int ans = f[prices.length-1];
        int maxValue = Integer.MIN_VALUE;
        // value存储i~n-1之间的最大利润
        int maxProfit = 0;
        for(int i=prices.length-1;i>0;i--){
            if(prices[i]>maxValue){
                maxValue = prices[i];
            }
            maxProfit = Math.max(maxProfit, maxValue-prices[i]);
            ans = Math.max(ans,f[i-1]+ maxProfit);
        }
        return ans;

    }
}
