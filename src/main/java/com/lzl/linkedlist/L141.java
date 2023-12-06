package com.lzl.linkedlist;

import com.lzl.util.ListNode;

/**
 * 141. 环形链表
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/06
 */
public class L141 {
    /**
     * 快慢指针，成环一定会遇到
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while (p1 != null) {
            p2 = p2.next;
            for (int i = 0; i < 2 && p1 != null; i++) {
                p1 = p1.next;
            }
            if (p1 == p2) return true;
        }
        return false;
    }
}
