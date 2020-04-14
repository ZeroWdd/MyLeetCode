package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-04-12 21:07
 * @Description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 整数拆分 {

    // 思路: 使用动态规划
    public int integerBreak(int n) {
        // 定义一个dp
        int[] dp = new int[n + 1];
        // 设定一些特殊值
        dp[1] = 1;

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        整数拆分 整数拆分 = new 整数拆分();
        整数拆分.integerBreak(10);
    }

}
