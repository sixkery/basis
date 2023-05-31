package com.sixkery.leetcode.code1_10;


import com.sixkery.leetcode.entity.ListNode;

/**
 * 2. 两数相加 中等
 *
 * @author sixkery
 * @since 2023/5/29
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        // 进位
        int carry = 0;
        if (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            carry = val1 + val2 + carry;
            ListNode node = new ListNode(carry % 10);
            cur.next = node;
            cur = cur.next;
            carry = carry / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        return head;

    }
}
