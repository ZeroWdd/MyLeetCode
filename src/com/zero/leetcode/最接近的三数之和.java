package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-05-24 8:06
 * @Description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 最接近的三数之和 {

    private int ret = Integer.MAX_VALUE;

    // 使用dfs
    public int threeSumClosest(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        dfs(nums, target, 0, 0, list);
        return ret;
    }

    public void dfs(int[] nums, int target, int start, int index, List<Integer> list) {
        // 1. 截止条件
        if (index == 3) {
            int temp = 0;
            for (int i = 0; i < index; i++) {
                temp += list.get(i);
            }

            if (ret == Integer.MAX_VALUE) {
                ret = temp;
            }else {
                ret = Math.abs(target - temp) < Math.abs(target - ret) ? temp : ret;
            }


            return;
        }

        // 2. 找出候选人
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, target, i + 1, index + 1, list);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        最接近的三数之和 最接近的三数之和 = new 最接近的三数之和();
        最接近的三数之和.threeSumClosest(new int[]{-1,2,1,4}, 1);

    }

}
