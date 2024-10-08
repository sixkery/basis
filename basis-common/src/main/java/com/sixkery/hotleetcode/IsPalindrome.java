package com.sixkery.hotleetcode;

import com.sixkery.leetcode.entity.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 234. 回文链表 easy
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * @author sixkery
 * @since 2023/7/3
 */
public class IsPalindrome {

    /**
     * 将值复制到数组中后用双指针法
     *
     * @param head 头节点
     * @return 是否回文链表
     */
    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int font = 0, back = list.size() - 1;
        while (font < back) {
            if (!Objects.equals(list.get(font), list.get(back))) {
                return false;
            }
            font++;
            back--;
        }
        return false;
    }
}