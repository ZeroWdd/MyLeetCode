package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 11:05
 * @Description: 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 第k个排序 {

    // 思路：使用dfs算法
    // 结果：超时
    // 方法：使用dfs时，达到第k个直接结束
    public String getPermutation(int n, int k) {
        // 创建数组
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1 + "";
        }
        // 返回值
        List<String> res = new ArrayList<>();

        int[] pb = new int[nums.length];

        dfs(nums, pb, 0, k, new StringBuilder(), res);

        return res.get(k - 1);
    }

    public void dfs(String[] nums, int[] pb, int index, int k, StringBuilder sb, List<String> res) {
        // 1. 截至条件
        if (res.size() == k) {
            return;
        }
        if (index == nums.length) {
            res.add(sb.toString());
            return;
        }

        // 2. 找出候选人
        for (int i = 0; i < nums.length; i++) {
            // 判断该数是否使用过
            if (pb[i] == 0) { // 默认0为未使用过
                sb.append(nums[i]);
                pb[i] = 1;
                dfs(nums, pb, index + 1, k, sb, res);
                sb.deleteCharAt(sb.length() - 1);
                pb[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        第k个排序 第k个排序 = new 第k个排序();
        第k个排序.getPermutation(3,2);
    }

}
