package com.lzl.linkedlist;

import com.lzl.util.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @author lzl
 * @version 1.0
 * @since 2023/12/03
 */
public class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list!=null){
                q.offer(list.val);
                list= list.next;
            }
        }
        ListNode head=new ListNode(0);
        ListNode p=head;
        while (!q.isEmpty()){
            Integer poll = q.poll();
            ListNode node = new ListNode();
            node.val=poll;
            p.next=node;
            p=p.next;
        }
        return head.next;
    }
}
