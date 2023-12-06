package com.lzl.linkedlist;

import com.lzl.util.ListNode;

/**
 * 876. 链表的中间结点
 * 简单
 * 相关标签
 * 相关企业
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/06
 */
public class L876 {
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = new ListNode();
        ListNode low = new ListNode();
        fast = dummy;
        low = dummy;
        while (fast != null) {
            low = low.next;
            for (int i = 0; i < 2 && fast != null; i++) {
                fast = fast.next;
            }
        }
        return low;
    }
}