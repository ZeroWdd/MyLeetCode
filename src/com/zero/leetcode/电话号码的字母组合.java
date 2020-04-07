package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-07 8:56
 * @Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class 电话号码的字母组合 {

    char m[][] = {
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    // 思路：使用DFS算法
    // 条件： 1. 退出条件 2. 筛选出候选人
    public List<String> letterCombinations(String str) {
        ArrayList<String> res = new ArrayList<>();
        // 特殊情况判断
        if (str.length() == 0 || str.equals("")){
            return res;
        }
        dfs(str, 0, new StringBuilder(), res);
        return res;
    }

    /**
     * dfs
     * @param str 输入的字符串
     * @param index 结束条件
     * @param sb 候选人
     * @param res 返回值
     */
    public void dfs(String str, int index, StringBuilder sb, List<String> res) {
        // 1. 截至条件
        if (str.length() == index) {
            res.add(sb.toString());
            return;
        }
        // 2. 找出候选人
        for (char c : m[str.charAt(index) - '0']) {
            sb.append(c);
            dfs(str, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
