package com.lzl.linkedlist;

import com.lzl.util.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/07
 */
public class L83 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(new L83().deleteDuplicates(n1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = new ListNode();
        ListNode slow = new ListNode();
        fast = head;
        slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}
