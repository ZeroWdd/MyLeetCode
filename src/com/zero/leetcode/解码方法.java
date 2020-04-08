package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-04-08 21:00
 * @Description: 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 解码方法 {

    // 思路: 使用动态规划

    /**
     * 定义dp[i]是nums前i个字符可以得到的解码种数，假设之前的字符串是123x，现在新加入了y，则有以下5种情况：
     *
     * 如果x=='0'，且y=='0'，无法解码，返回0；
     * 如果只有x=='0'，则y只能单独放在最后，不能与x合并(不能以0开头)，此时有：
     * dp[i] = dp[i-1]
     * 如果只有y=='0'，则y不能单独放置，必须与x合并，并且如果合并结果大于26，返回0，否则有：
     * dp[i] = dp[i-2]
     * 如果 xy<=26: 则y可以“单独”放在123x的每个解码结果之后后，并且如果123x以x单独结尾，此时可以合并xy作为结尾，而这种解码种数就是abc的解码结果，此时有：
     * dp[i] = dp[i-1] + dp[i-2]
     * 如果 xy>26: 此时x又不能与y合并，y只能单独放在dp[i]的每一种情况的最后，此时有：
     * dp[i] = dp[i-1]
     *
     * 作者：zackqf
     * 链接：https://leetcode-cn.com/problems/decode-ways/solution/javajie-ti-si-lu-xiang-jie-by-zackqf/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0') {
                return 0;
            }
            if (s.charAt(i - 1) == '0' && s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
                continue;
            }
            if (s.charAt(i - 1) != '0' && s.charAt(i) == '0') {
                if (s.charAt(i - 1) > '2') {
                    return 0;
                }else {
                    if (i == 1) {
                        dp[i] = 1;
                    }else {
                        dp[i] = dp[i - 2];
                    }
                    continue;
                }
            }
            if (s.charAt(i - 1) < '2' || (s.charAt(i - 1) == '2' &&  s.charAt(i) <= '6')) {
                if (i == 1) {
                    dp[i] = 2;
                }else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        解码方法 解码方法 = new 解码方法();
        解码方法.numDecodings("17");
    }

}
