package com.zero.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 10:25
 * @Description: 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 组合总和II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 候选人
        ArrayList<Integer> list = new ArrayList<>();
        // 返回值
        List<List<Integer>> res = new ArrayList<>();

        // 特殊条件判断
        if (candidates.length == 0) {
            return res;
        }

        int[] pb = new int[candidates.length];

        dfs(candidates, pb, target, list, 0, res);
        return res;
    }

    public void dfs(int[] candidates, int[] pb, int target, List<Integer> list, int num, List<List<Integer>> res) {
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
            // 判断是否已使用过
            if (pb[i] == 0) { // 等于0表示尚未使用过
                num += candidates[i];
                list.add(candidates[i]);
                pb[i] = 1;
                dfs(candidates, pb, target, list, num, res);
                num -= candidates[i];
                list.remove(list.size() - 1);
                pb[i] = 0;
            }
        }
    }

}
