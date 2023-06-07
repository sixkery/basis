package com.sixkery.leetcode.code1_10;

import com.sixkery.leetcode.entity.ListNode;

/**
 * 反转链表
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
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
