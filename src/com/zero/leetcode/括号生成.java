package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 9:34
 * @Description: 给出 n 代表生成括号的对数，请你写出一个函数，
 * 使其能够生成所有可能的并且有效的括号组合。
 */
public class 括号生成 {

    // 思路：使用DFS算法
    public List<String> generateParenthesis(int n) {
        int[] pb = {n, n};
        ArrayList<String> res = new ArrayList<>();
        // 特殊条件判断
        if (n <= 0) {
            return res;
        }
        dfs(n, pb, new StringBuilder(), res);
        return res;
    }

    // 判断不符合条件：当剩余左括号 = 剩余右括号，只能先放左括号，否则不满足条件
    public void dfs(int n, int[] pb, StringBuilder sb, List<String> res) {
        // 1. 截至条件
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        // 2. 找出候选人
        if (pb[0] > 0) {
            pb[0]--;
            sb.append("(");
            dfs(n, pb, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            pb[0]++;
        }
        if (pb[1] > 0 && pb[1] > pb[0]) {
            pb[1]--;
            sb.append(")");
            dfs(n, pb, sb, res);
            sb.deleteCharAt(sb.length() - 1);
            pb[1]++;
        }
    }

}
