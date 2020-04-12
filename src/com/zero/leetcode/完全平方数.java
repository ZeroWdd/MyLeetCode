package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-04-11 15:41
 * @Description:
 */
public class 完全平方数 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏情况
            for (int j = 1; j < i; j++) {
                if (i - j * j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }

}
