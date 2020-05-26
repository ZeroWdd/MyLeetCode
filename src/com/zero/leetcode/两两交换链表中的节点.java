package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-05-26 17:27
 * @Description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两两交换链表中的节点 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode headNode = new ListNode(0);

        headNode.next = head;

        ListNode temp = headNode;

        while (temp.next != null && temp.next.next != null) {
            ListNode cur = temp;
            ListNode one = cur.next;
            ListNode two = cur.next.next;

            one.next = two.next;
            two.next = cur.next;
            cur.next = two;

            temp = one;
        }

        return headNode.next;

    }
}
