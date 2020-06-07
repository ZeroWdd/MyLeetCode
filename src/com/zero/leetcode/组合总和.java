package com.zero.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 9:55
 * @Description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 组合总和 {

    // 思路：使用dfs算法
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 候选人
        ArrayList<Integer> list = new ArrayList<>();
        // 返回值
        List<List<Integer>> res = new ArrayList<>();

        // 特殊条件判断
        if (candidates.length == 0) {
            return res;
        }

        dfs(candidates, target, list, 0, res);

        return res;
    }

    public void dfs(int[] candidates, int target, List<Integer> list, int num, List<List<Integer>> res) {
        // 1. 截至条件
        if (num == target) {
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            if (!res.contains(temp)) {
                res.add(temp);
            }
            return;
        }
        if (num > target) {
            return;
        }
        // 2. 找出候选人
        for (int i = 0; i < candidates.length; i++) {
            num += candidates[i];
            list.add(candidates[i]);
            dfs(candidates, target, list, num, res);
            num -= candidates[i];
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        组合总和 组合总和 = new 组合总和();
        组合总和.combinationSum(candidates, target);
    }

}
