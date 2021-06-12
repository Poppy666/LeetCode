package com.leetcode.dp;

/**
 * Created with IntelliJ IDEA
 * Project: 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 思路：动态规划
 * 用 D[i][j] 表示 A 的前 i 个字母和 B 的前 j 个字母之间的编辑距离。
 * D[i][j]=min{D[i][j-1]+1,D[i-1][j]+1,D[i-1][j-1]+int(word1[i]!=word2[j]}
 * dp[0][2]就表示空串""和“ro”的编辑距离
 * Author: jingren
 * Date: 2021/5/18
 */
public class solution72 {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        if (m * n == 0) {
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
