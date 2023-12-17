package com.lzl.linkedlist;

import com.lzl.util.ListNode;

/**
 * 206. 反转链表
 * 简单
 * 相关标签
 * 相关企业
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/17
 */
public class L206 {
    public static void main(String[] args) {
        new L206().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, null))));
    }

    /**
     * 非递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            // 保存下一个节点
            ListNode t = cur.next;
            // 当前节点的下个节点指向前节点
            cur.next = prev;
            // 前节点指向当前节点
            prev = cur;
            // 当前节点后移，指向下一节点
            cur = t;
        }
        return prev;
    }

    /**
     * 递归的做法，前序遍历
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        head = dfs(head, null);
        return head;
    }

    private ListNode dfs(ListNode cur, ListNode prev) {
        if (cur == null) {
            return prev;
        }
        ListNode t = cur.next;
        cur.next = prev;
        cur = dfs(t, cur);
        return cur;
    }
}
