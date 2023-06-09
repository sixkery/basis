package com.sixkery.leetcode.listnode;

import com.sixkery.leetcode.entity.ListNode;

/**
 * 206. 反转链表 easy
 *
 * @author sixkery
 * @since 2023/6/7
 */
public class ReverseListNode {
    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseListNode(head.next);
        // 把最后一位的下个指针指向前一位
        head.next.next = head;
        // 倒数第二位的指针断掉
        head.next = null;
        return cur;
    }

    /**
     * 双指针，
     * @param head 链表
     * @return 反转后的链表
     */
    public ListNode reverseListNode2(ListNode head) {

        // 申请节点，pre和 cur，pre指向null
        ListNode temp = null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 记录当前节点的下一个节点
            temp = cur.next;
            // 当前节点指向 pre
            cur.next = pre;
            // pre 和 cur 节点都前进一位
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
