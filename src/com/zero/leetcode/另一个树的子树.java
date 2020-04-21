package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-04-21 20:47
 * @Description: 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 另一个树的子树 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        //三个条件满足其中一个即可
        //1.判断t与树s是不是结构相等
        //2.判断树t是不是树s左子树的子结构
        //3.判断树t是不是树s右子树的子结构
        return subTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean subTree(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s== null || t== null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return subTree(s.left,t.left) && subTree(s.right,t.right);
    }


}
