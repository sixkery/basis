package com.sixkery.leetcode.entity;

import lombok.Data;

/**
 * created by sixkery on 2022/1/11.
 */

@Data
public class ListNode {

    public  int val;
    public  ListNode next;

    ListNode() {
    }


    public ListNode(int x) {
        val = x;
    }


}
