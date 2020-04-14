package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-04-14 18:42
 * @Description:
 */
public class 计算各个位数不同的数字个数 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0 ) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 记录剩余的情况
        int count = 9;
        // 记录当前个数
        int ret = 9;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + ret;
            ret *= count;
            count--;
        }

        return dp[n];
    }

}
