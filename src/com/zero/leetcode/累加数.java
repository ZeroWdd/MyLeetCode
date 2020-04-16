package com.zero.leetcode;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.ArrayList;

/**
 * @Auther: wdd
 * @Date: 2020-04-16 15:23
 * @Description: 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 *
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 *
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 累加数 {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }

        char[] chars = num.toCharArray();
        long pre1, pre2;

        // 起始数字要满足：
        // 1.开头不为0
        // 2.长度不超过总长度的一半
        for (int i = 0; i < num.length() / 2; i ++) {
            if (chars[0] == '0' && i > 0) {
                break;
            }

            pre1 = getNum(chars, 0, i);

            for (int j = i+1; j < num.length(); j ++) {
                if (chars[i+1] == '0' && j > i + 1) {
                    break;
                }

                pre2 = getNum(chars, i+1, j);

                if (isAdditiveNumberCore(chars, j+1, pre1, pre2)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 前两个数相加等于第三个数，如果不符返回false
     */
    private boolean isAdditiveNumberCore(char[] num, int start, long pre1, long pre2) {
        long target = pre1 + pre2;
        int length = String.valueOf(target).length();
        if (getNum(num, start, start + length - 1) != target) {
            return false;
        }

        start = start + length;
        return start == num.length || isAdditiveNumberCore(num, start, pre2, target);
    }

    /**
     * 获取当前数字
     */
    private long getNum(char[] chars, int start, int end) {
        if (end >= chars.length) {
            return -1;
        }

        long ans = 0;
        for (int i = start; i <= end; i ++) {
            ans *= 10;
            ans += (chars[i] - '0');
        }

        return ans;
    }


    public static void main(String[] args) {
        // 累加数 累加数 = new 累加数();
        // 累加数.isAdditiveNumber("19910011992");
        System.out.println(Long.MAX_VALUE);
    }

}
