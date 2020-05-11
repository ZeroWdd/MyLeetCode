package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-05-06 9:05
 * @Description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        int left = 0, right = n - 1;
        int mid = (left + right) / 2;

        while (left <= right) {//找首次出现
            if (nums[mid] >= target) right = mid - 1;//即使当前元素是target也要抛弃掉，继续缩小左半区间
            else left = mid + 1;//在右半区间里找
            mid = (left + right) / 2;
        }
        if (left == n || nums[left] != target) return new int[]{-1, -1};//left即target第一次出现的位置，可能没有target，此时left越界
        int res1 = left;//left最终值是左半区间的右边的位置
        left = 0;
        right = n - 1;
        while (left <= right) {
            if (nums[mid] <= target) left = mid + 1;//即使找到target也抛弃掉，进一步缩小右半区间
            else right = mid - 1;//在左半区间里
            mid = (left + right) / 2;
        }
        int res2 = right;//最后出现，right最终值是右半区间的左边的一个位置
        return new int[]{res1, res2};
    }

}
