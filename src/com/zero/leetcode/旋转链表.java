package com.zero.leetcode;

/**
 * @Auther: wdd
 * @Date: 2020/6/7 21:07
 * @Description: 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 旋转链表 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int num = 1;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
            num++;
        }
        //获取实际需要移动的步数
        int step = k % num;
        //不需要移动
        if (step == 0) {
            return head;
        }
        //尾首相连
        ptr.next = head;
        return moveHelper(head, step, num);
    }

    private ListNode moveHelper(ListNode head, int step, int num) {
        int count = 0;
        ListNode temp = head;
        //找到链表需要断开的位置
        while (count < num - step - 1) {
            temp = temp.next;
            count++;
        }
        //获取结果链表的起点
        ListNode res = temp.next;
        temp.next = null;
        return res;
    }

}
