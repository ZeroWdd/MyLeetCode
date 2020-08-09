package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020/6/18 21:01
 * @Description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 颜色分类 {

    public void sortColors(int[] nums) {
        // 创建三个指针 分别表示0的最右边，2的最左边，当前索引
        int index1 = 0;
        int index2 = nums.length - 1;
        int curIndex = 0;

        while (curIndex <= index2) {
            if (nums[curIndex] == 0) {
                nums[curIndex++] = nums[index1];
                nums[index1++] = 0;
            }else if (nums[curIndex] == 2) {
                nums[curIndex] = nums[index2];
                nums[index2--] = 2;
            }else {
                curIndex++;
            }
        }
    }

}
