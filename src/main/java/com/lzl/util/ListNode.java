package com.lzl.util;

/**
 * @Description
 * @Author LZL
 * @Date 2021.09.24-14:58
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
