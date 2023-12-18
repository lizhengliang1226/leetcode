package com.lzl.linkedlist;

import com.lzl.util.ListNode;

/**
 * 234. 回文链表
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/18
 */
public class L234 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n5;
        n5.next = n3;
        n3.next = n4;
        System.out.println(new L234().isPalindrome(n1));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 计算节点数
        int count = 0;
        for (; head != null; head = head.next) {
            count++;
        }
        // 回文，只取前半段节点
        int len = count % 2 == 0 ? count / 2 : count / 2 + 1;
        ListNode firstHalf = new ListNode();
        ListNode secondHalf = dummy.next;
        // 构建前半段链表
        for (int i = 0; i < len; i++) {
            ListNode temp = secondHalf;
            secondHalf = secondHalf.next;
            temp.next = firstHalf;
            firstHalf = temp;
        }
        // 根据长度判断前半段链表是是否要先走一步，单数则要先走一步
        firstHalf = count % 2 == 0 ? firstHalf : firstHalf.next;
        // 构建完成后，secondHalf就是后半段链表的起点
        // 两两比较是否相同，循环结束条件必须是secondHalf不为空，因为firstHalf初始化了，在构建完成时会比secondHalf多一个节点在最后
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
}