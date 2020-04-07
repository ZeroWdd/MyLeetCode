package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 17:20
 * @Description:
 */
public class 最小路径和 {

    // 思路：动态规划
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        最小路径和 最小路径和 = new 最小路径和();
        int[][] grid = {
                {1,2,5},
                {3,2,1}
        };
        最小路径和.minPathSum(grid);
    }
}
