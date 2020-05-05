package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020-04-28 10:10
 * @Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 删除链表的倒数第N个节点 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode A = new ListNode(-1);
        A.next = head;
        ListNode p = A;
        ListNode q = A;
        for(int i = 1; i <= n+1; i++){
            p = p.next;
        }
        while (p != null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return A.next;

    }
}
