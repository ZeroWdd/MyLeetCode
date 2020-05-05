package com.zero.leetcode;

import java.util.HashMap;

/**
 * @Auther: wdd
 * @Date: 2020-04-28 9:49
 * @Description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 多数元素 {


    public int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            }else {
                Integer n = map.get(nums[i]);
                if ((n + 1) > nums.length/2) {
                    return nums[i];
                }else {
                    map.put(nums[i], n + 1);
                }
            }

        }

        return -1;
    }

}
