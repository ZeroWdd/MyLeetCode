package com.zero.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-09 10:32
 * @Description: 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 子集II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            if (!res.contains(new ArrayList<>(temp))) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        List<Integer> temp = new ArrayList<>(list);
        Collections.sort(temp);
        if (!res.contains(new ArrayList<>(temp))) {
            res.add(new ArrayList<>(temp));
        }

        // 2. 找出候选人
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, index + 1, list, res);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        子集II 子集II = new 子集II();
        子集II.subsetsWithDup(new int[]{1,2,2});
    }

}
