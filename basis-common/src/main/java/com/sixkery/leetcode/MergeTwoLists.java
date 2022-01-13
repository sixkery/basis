package com.sixkery.leetcode;


import com.sixkery.leetcode.entity.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * created by sixkery on 2022/1/11.
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        // 当前操作的指针
        ListNode current = result;
        while (list1 != null && list2 != null) {
            if (ListNode.val > list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        if (list1 == null) {
            current.next = list2;
        }
        if (list2 == null) {
            current.next = list1;
        }

        return result.next;

    }

    /**
     * 递归解法
     *
     * @param list1 第一个链表
     * @param list2 第二个链表
     * @return 合并的链表
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {

            return mergeTwoLists2(list1, list2.next);
        } else {
            return mergeTwoLists2(list1.next, list2);
        }


    }

}

