package com.zero.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-04-17 9:17
 * @Description: 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * <p>
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 * <p>
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sequential-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 顺次数 {

    private static final String digits = "123456789";

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new LinkedList<>();

        for (int i = 2; i <= 9; i++) {
            for (int m = 0, n = m + i; n <= 9; m++, n++) {
                int value = Integer.valueOf(digits.substring(m, n));
                if (value >= low && value <= high) {
                    result.add(value);
                } else if (value > high) {
                    break;
                }
            }
        }

        return result;
    }

}
