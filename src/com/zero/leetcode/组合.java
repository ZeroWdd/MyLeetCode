package com.zero.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 11:31
 * @Description: 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 组合 {

    // 思路：使用dfs算法
    // 结果: 超时
    // 处理办法： 不适用排序来解决数组重复问题
    public List<List<Integer>> combine(int n, int k) {
        // 创建数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        // 候选人
        ArrayList<Integer> list = new ArrayList<>();
        // 返回值
        List<List<Integer>> res = new ArrayList<>();


        dfs(nums, k, 0, list, res);

        return res;
    }

    public void dfs(int[] nums, int k, int start, List<Integer> list, List<List<Integer>> res) {
        // 1. 截至条件
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        // 2. 找出候选人
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, k, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        组合 组合 = new 组合();
        组合.combine(4, 2);
    }
}
