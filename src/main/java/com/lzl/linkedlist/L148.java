package com.lzl.linkedlist;

import com.lzl.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 148. 排序链表
 * 中等
 * 相关标签
 * 相关企业
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/18
 */
public class L148 {
    public static void main(String[] args) {
//        ListNode n4 = new ListNode(4);
//        ListNode n2 = new ListNode(2);
//        ListNode n1 = new ListNode(1);
//        ListNode n3 = new ListNode(3);
//        n4.next = n2;
//        n2.next = n1;
//        n1.next = n3;
//
//        System.out.println(new L148().sortList(n4));

        ListNode n1 = new ListNode(-1);
        ListNode n5 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n0 = new ListNode(0);
        n1.next=n5;
        n5.next=n3;
        n3.next=n4;
        n4.next=n0;
        System.out.println(new L148().sortList(n1));
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p2 = head.next;
        ListNode prev1 = dummy.next;
        Label1: while (p2 != null) {
            // 每次都从头节点开始跑
            ListNode t = dummy.next;
            ListNode prev2 = dummy;
            while (t != null && t.val < p2.val) {
                prev2 = t;
                t = t.next;
                if(t==p2){
                    p2=p2.next;
                    continue Label1;
                }
            }
            // 此时的t刚好大于p2，p2应该放在他的前面
            ListNode next = p2.next;
            prev1.next = next;
            p2.next = t;
            prev2.next = p2;

            p2 = next;
        }
        return dummy.next;
    }

    /**
     * 最简单粗暴的写法，有效但没啥技术含量
     *
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        List<Integer> arr = new ArrayList<>();
        while (p != null) {
            arr.add(p.val);
            p = p.next;
        }
        arr.sort((o1, o2) -> o1 - o2);
        ListNode p1 = head;
        for (Integer i : arr) {
            p1.val = i;
            p1 = p1.next;
        }
        return dummy.next;
    }
}
