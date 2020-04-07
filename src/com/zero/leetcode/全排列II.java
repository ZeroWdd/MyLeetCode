package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 10:52
 * @Description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class 全排列II {

    // 思路：使用dfs算法
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 候选人
        ArrayList<Integer> list = new ArrayList<>();
        // 返回值
        List<List<Integer>> res = new ArrayList<>();

        // 特殊条件判断
        if (nums.length == 0) {
            return res;
        }

        int[] pb = new int[nums.length];

        dfs(nums, pb, 0, list, res);

        return res;
    }

    public void dfs(int[] nums, int[] pb, int index, List<Integer> list, List<List<Integer>> res) {
        // 1. 截至条件
        if (index == nums.length) {
            if (!res.contains(new ArrayList<>(list))) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        // 2. 找出候选人
        for (int i = 0; i < nums.length; i++) {
            // 判断该数是否使用过
            if (pb[i] == 0) { // 默认0为未使用过
                list.add(nums[i]);
                pb[i] = 1;
                dfs(nums, pb, index + 1, list, res);
                list.remove(list.size() - 1);
                pb[i] = 0;
            }
        }
    }
}
