package com.lzl.linkedlist;

import com.lzl.util.ListNode;

/**
 * 142. 环形链表 II
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/06
 */
public class L142 {
    /**
     * 先判断成环，此时到达相遇点，假设相遇点到环起点为m，慢指针走了k步，则环大小为k，此次定义一个从头节点开始走的指针和当前相遇点指针一起走，k-m步后到达环起点
     * 相遇时即为环起点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while (p1 != null) {
            p2 = p2.next;
            for (int i = 0; i < 2 && p1 != null; i++) {
                p1 = p1.next;
            }
            if (p1 == p2) {
                ListNode p3 = dummy;
                // 一定有环了，不用判空
                while (p3 != p1) {
                    p3 = p3.next;
                    p1 = p1.next;
                }
                return p1;
            }
        }
        return null;
    }
}
