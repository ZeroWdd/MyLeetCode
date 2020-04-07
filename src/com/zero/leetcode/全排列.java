package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 10:41
 * @Description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class 全排列 {

    // 思路：使用dfs算法
    public List<List<Integer>> permute(int[] nums) {
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
            res.add(new ArrayList<>(list));
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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        全排列 全排列 = new 全排列();
        List<List<Integer>> list = 全排列.permute(nums);
        System.out.println(list);
    }
}
