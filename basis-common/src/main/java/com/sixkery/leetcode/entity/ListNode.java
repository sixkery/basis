package com.sixkery.leetcode.entity;

import lombok.Data;

/**
 * created by sixkery on 2022/1/11.
 */

@Data
public class ListNode {

    public static int val;
    public static ListNode next;

    ListNode() {
    }


    public ListNode(int val) {
        ListNode.val = val;
    }

    ListNode(int val, ListNode next) {
        ListNode.val = val;
        ListNode.next = next;
    }
}
