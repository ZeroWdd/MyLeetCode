package com.zero.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-17 8:58
 * @Description: 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 组合总和III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        int[] pb = new int[10];
        dfs(k, n, 0, pb, list, ret);
        return ret;
    }

    public void dfs(int k, int n, int index, int[] pb, List<Integer> list, List<List<Integer>> ret) {
        // 1. 截至条件
        if (index != 0) {
            int num = 0;
            for (Integer i : list) {
                num += i;
            }
            if (num == n && index == k) {
                ArrayList<Integer> arrayList = new ArrayList<>(list);
                Collections.sort(arrayList);
                if (!ret.contains(arrayList)) {
                    ret.add(arrayList);
                }
                return;
            }else if (num > n) {
                return;
            }else if (index > k) {
                return;
            }
        }

        // 2. 找出候选人
        for (int i = 1; i <= 9; i++) {
            if (pb[i] == 0) {
                pb[i] = 1;
                list.add(i);
                dfs(k, n, index + 1, pb, list, ret);
                list.remove(list.size() - 1);
                pb[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        组合总和III 组合总和III = new 组合总和III();
        组合总和III.combinationSum3(3, 7);
    }
}
