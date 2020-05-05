package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-04-28 9:36
 * @Description: 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class 反转链表 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode hNode = head;
        ListNode cur = new ListNode(-1);

        while (hNode != null) {
            ListNode node = hNode.next;
            hNode.next = cur.next;
            cur.next = hNode;
            hNode = node;
        }

        return cur.next;

    }
}
