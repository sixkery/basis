package com.sixkery.leetcode.listnode;

import com.sixkery.leetcode.entity.ListNode;

/**
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照顺序的方式存储的，并且每个节点只能存储一位数字，请你将两个数相减，
 * 并以相同形式返回一个表示相减结果的链表。
 * 你可以假设
 * 1) 除了数字0之外，这两个数都不会以0开头。2)给定的第一数字一定比第二个数字大。
 * <p>
 * 举例:
 * <p>
 * 输入: I1 = [9,8,7],I2 = [5,1,2]
 * <p>
 * 输出:[4, 7, 5]
 * <p>
 * 解释:987 - 512 = 475
 * 两数相减
 *
 * @author sixkery
 * @since 2023/6/9
 */
public class SubtractTwoNumbers {

    public ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个虚拟头节点
        ListNode dummyHead = new ListNode(0);
        // 定义当前节点
        ListNode cur = dummyHead;
        // 定义进位
        int borrow = 0;

        while (l1 != null && l2 != null) {
            int diff = l1.val - l2.val - borrow;
            if (diff <= 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            cur.next = new ListNode(diff);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int diff = l1.val - borrow;
            if (diff <= 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            cur.next = new ListNode(diff);
            cur = cur.next;
            l1 = l1.next;
        }
        return dummyHead.next;


    }
}
