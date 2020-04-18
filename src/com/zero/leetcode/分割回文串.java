package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-16 21:15
 * @Description: 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 分割回文串 {

    public List<List<String>> partition(String s) {

        ArrayList<String> list = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();

        dfs(s, 0, 1, list, ret);
        return ret;
    }

    public void dfs(String s, int index, int start, ArrayList<String> list, List<List<String>> ret) {
        // 1. 截至条件
        if (list.size() > 0) {
            String s1 = list.get(list.size() - 1);
            StringBuilder sb = new StringBuilder(s1);
            StringBuilder reverse = sb.reverse();
            String s2 = String.valueOf(reverse);
            if (!s1.equals(s2)) {
                return;
            }else if (start > s.length()) {
                ret.add(new ArrayList<>(list));
                return;
            }
        }


        // 2. 找出候选人
        for (int i = start; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            list.add(substring);
            dfs(s, i, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        分割回文串 分割回文串 = new 分割回文串();
        分割回文串.partition("aaa");

    }


}
