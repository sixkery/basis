package com.sixkery.hotleetcode;

import com.sixkery.leetcode.entity.ListNode;

/**
 * 206. 反转链表 easy
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @author sixkery
 * @since 2023/6/7
 */
public class ReverseListNode {
    public static ListNode reverseListNode(ListNode head) {
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
     *
     * @param head 链表
     * @return 反转后的链表
     */
    public static ListNode reverseListNode2(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }

        return pre;

    }

    public static void main(String[] args) {
        // 写一个测试用例，测试 reverseListNode 方法
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        final ListNode listNode = reverseListNode2(head);

        System.out.println("head = " + listNode);
    }
}
