package com.zero.leetcode;

import java.util.Arrays;

/**
 * @Auther: wdd
 * @Date: 2020-04-11 18:05
 * @Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最长上升子序列 {

    public int lengthOfLIS(int[] nums) {

        // dp[i]即代表nums[i]位置最长的长度, 默认为1
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        最长上升子序列 最长上升子序列 = new 最长上升子序列();
        最长上升子序列.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}


