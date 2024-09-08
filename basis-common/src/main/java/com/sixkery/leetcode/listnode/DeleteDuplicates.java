package com.sixkery.leetcode.listnode;

import com.sixkery.leetcode.entity.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * 83. 删除排序链表中的重复元素
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * @author sixkery
 * @since 2023/6/12
 */
@Slf4j
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode result = new DeleteDuplicates().deleteDuplicates(head);
        log.info(String.valueOf(result));
    }
}
