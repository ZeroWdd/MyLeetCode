package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020/6/9 17:54
 * @Description: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 反转链表II {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n) {
            return head;
        }

        ListNode PHead = head;

        ListNode ret = new ListNode(0);

        ListNode PRet = ret;

        for (int i = 1; i < m; i++) {
            PRet.next = PHead;
            PHead = PHead.next;
            PRet = PRet.next;
        }

        PRet.next = null;

        int num = n - m;


        for (int i = 0; i <= num; i++) {
            ListNode node = PHead.next;
            PHead.next = PRet.next;
            PRet.next = PHead;
            PHead = node;
        }

        for (int i = 0; i <= num; i++) {
            PRet = PRet.next;
        }


        while (PHead != null) {
            PRet.next = PHead;
            PHead = PHead.next;
            PRet = PRet.next;
        }

        return ret.next;
    }


    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);

        node.next = node1;
        node1.next = node2;

        反转链表II 反转链表II = new 反转链表II();

        反转链表II.reverseBetween(node, 2 ,3);
    }
}
