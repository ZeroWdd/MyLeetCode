package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-17 21:07
 * @Description: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 * <p>
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 回文子串 {

    public int countSubstrings(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            count++;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[j + 1] == 1) {
                    dp[j] = 1;
                    count++;
                } else {
                    dp[j] = 0;
                }
            }
        }
        return count;

        // char[] c = s.toCharArray();
        // int len = c.length;
        // boolean[][] dp = new boolean[len][len];
        // int ans = 0;
        // for(int l = 1; l <= len; l++)
        // {
        //     for(int i = 0; i+l-1 < len; i++)
        //     {
        //         int j = i + l - 1;
        //         if(c[i] == c[j] && (j-i <= 2 || dp[i+1][j-1]))
        //         {
        //             dp[i][j] = true;
        //             ans++;
        //         }
        //     }
        // }
        // return ans;

    }

    public static void main(String[] args) {
        回文子串 回文子串 = new 回文子串();
        回文子串.countSubstrings("abc");
    }

}
