package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-05-05 17:38
 * @Description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        // 定义两个指针
        int left = 0;
        int right = height.length - 1;

        // 定义最大容器
        int ret = 0;

        while (left < right) {
            int count = Math.min(height[left], height[right]) * (right - left);
            ret = Math.max(ret, count);
            if (height[left] <= height[right]) {
                left++;
            }else {
                right--;
            }
        }

        return ret;
    }

}
