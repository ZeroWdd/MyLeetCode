package com.zero.leetcode;

import java.util.Stack;

/**
 * @Auther: wdd
 * @Date: 2020-05-11 16:43
 * @Description: 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树展开为链表 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Stack<TreeNode> stack = new Stack<>();

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root;

        if (temp.left != null && temp.right != null) {
            stack.push(temp.right);
            temp.right = temp.left;
            temp.left = null;
            temp = temp.right;
            flatten(temp);
        }
        if (temp.left == null && temp.right == null) {
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                temp.right = pop;
                temp = temp.right;
                flatten(temp);
            }
        }
        if (temp.left != null && temp.right == null) {
            temp.right = temp.left;
            temp.left = null;
            temp = temp.right;
            flatten(temp);
        }
        if (temp.left == null && temp.right != null) {
            temp = temp.right;
            flatten(temp);
        }

    }
}
