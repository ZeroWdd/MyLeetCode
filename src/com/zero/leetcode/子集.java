package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-08 20:41
 * @Description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 子集 {

    // 思路: 使用dfs算法
    public List<List<Integer>> subsets(int[] nums) {
        // 候选人
        List<Integer> list = new ArrayList<>();
        // 返回值
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, 0, 0, list, res);

        return res;
    }

    public void dfs(int[] nums, int start, int index, List<Integer> list, List<List<Integer>> res) {
        // 1. 截至条件
        if (nums.length == index) {
            res.add(new ArrayList<>(list));
            return;
        }

        res.add(new ArrayList<>(list));

        // 2. 找出候选人
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, index + 1, list, res);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        子集 子集 = new 子集();
        子集.subsets(new int[]{1,2,3});
    }

}
