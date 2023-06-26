package com.sixkery.leetcode.listnode;

import com.sixkery.leetcode.entity.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author sixkery
 * @since 2023/6/9
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            // 比较两个指针，将小的节点接到 head 上
            if (list1.val > list2.val) {
                head.next = list2;
                list2 = list2.next;
            } else {
                head.next = list1;
                list1 = list1.next;
            }
            // head 不断前进
            head = head.next;
        }
        head.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
