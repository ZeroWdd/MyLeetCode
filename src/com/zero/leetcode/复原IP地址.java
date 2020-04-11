package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-09 10:51
 * @Description: 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 复原IP地址 {

    public List<String> restoreIpAddresses(String s) {
        // 返回值
        List<String> res = new ArrayList<>();

        dfs(s, 0, 0, "", res);

        return res;
    }

    public void dfs(String s, int index, int level, String str, List<String> res) {
        // 1. 截至条件
        if (s.length() == index || level == 4) {
            if (s.length() == index && level == 4) {
                res.add(str);
            }
            return;
        }

        // 2. 找出候选人
        for (int i = 0; i < 3; i++) {
            if ((index + i + 1) >= s.length() + 1) {
                continue;
            }
            String x = s.substring(index, index + i + 1);
            String temp = "";
            if (Integer.parseInt(x) < 256 && ("0".equals(x) || !x.startsWith("0"))) {
                temp = str;
                if (str == "" || str == null) {
                    str += x;
                }else {
                    str += "." + x;
                }
                dfs(s, index + i + 1, level + 1, str, res);
                str = temp;
            }
        }
    }

    public static void main(String[] args) {
        复原IP地址 复原IP地址 = new 复原IP地址();
        复原IP地址.restoreIpAddresses("0000");
    }

}
