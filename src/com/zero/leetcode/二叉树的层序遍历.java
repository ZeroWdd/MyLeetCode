package com.zero.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wdd
 * @Date: 2020-05-17 17:34
 * @Description: 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 二叉树的层序遍历 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        ArrayList<TreeNode> treeNodes1 = new ArrayList<>();
        ArrayList<TreeNode> treeNodes2 = new ArrayList<>();
        treeNodes1.add(root);
        while (treeNodes1.size() != 0 || treeNodes2.size() != 0) {
            if (treeNodes1.size() != 0) {
                ArrayList<Integer> list = new ArrayList<>();
                while (treeNodes1.size() != 0) {
                    TreeNode node = treeNodes1.remove(0);
                    list.add(node.val);
                    if (node.left != null) {
                        treeNodes2.add(node.left);
                    }
                    if (node.right != null) {
                        treeNodes2.add(node.right);
                    }
                }
                ret.add(list);
            }
            if (treeNodes2.size() != 0) {
                ArrayList<Integer> list = new ArrayList<>();
                while (treeNodes2.size() != 0) {
                    TreeNode node = treeNodes2.remove(0);
                    list.add(node.val);
                    if (node.left != null) {
                        treeNodes1.add(node.left);
                    }
                    if (node.right != null) {
                        treeNodes1.add(node.right);
                    }
                }
                ret.add(list);
            }
        }
        return ret;
    }


}
