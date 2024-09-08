package com.sixkery.hotleetcode;

import com.sixkery.leetcode.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * @author sixkery
 * @since 2024/9/1
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (!set.add(cur.val)) {
                return true;
            }
            cur = cur.next;
        }
        return false;

    }

    public static void main(String[] args) {
        // 测试 hasCycle 方法
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        final boolean b = hasCycle(head);
        System.out.println("b = " + b);


    }
}
