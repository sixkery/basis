package com.sixkery.leetcode.code1_10;

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
}
