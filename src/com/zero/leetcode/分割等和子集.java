package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020/6/10 22:01
 * @Description: 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 分割等和子集 {

    public boolean canPartition(int[] nums) {

        // 将数据相加，若为奇数则必然不行。
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num += nums[i];
        }
        if (num % 2 != 0) {
            return false;
        }
        
        // 将数据除以2
        num = num >> 1;
        
        // 创建dp
        boolean[][] dp = new boolean[nums.length + 1][num + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= num; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j-nums[i-1]];
                }
            }
            
        }

        return dp[nums.length][num];
    }
}
