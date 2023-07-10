package com.sixkery.leetcode.listnode;

import com.sixkery.leetcode.entity.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点 medium
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * @author sixkery
 * @since 2023/7/10
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fastNode = dummy;
        ListNode slowNode = dummy;

        // 只要快慢指针相差 n 个结点即可
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        // 此时 slowIndex 的位置就是待删除元素的前一个位置。
        slowNode.next = slowNode.next.next;
        return dummy.next;
    }
}
