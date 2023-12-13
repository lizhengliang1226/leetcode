package com.lzl.monostack;

import com.lzl.util.ListNode;

import java.util.Arrays;

/**
 * 1019. 链表中的下一个更大节点
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个长度为 n 的链表 head
 * <p>
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * <p>
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/13
 */
public class L1019 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(3);
//        head.next.next = new ListNode(5);
//        head.next.next.next = new ListNode(0);
//        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(6);
        System.out.println(Arrays.toString(new L1019().nextLargerNodes(head)));
    }

    /**
     * 后序遍历加反向单调栈，右右大小大
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        dfs(head, 0);
        return ans;
    }

    int[] ans;
    int[] stack = new int[10000];
    int lens = 0;

    private void dfs(ListNode head, int index) {
        // 右右大小大
        if (head == null) {
            ans = new int[index];
            return;
        }
        dfs(head.next, index + 1);
        // 此处必须严格小于等于，这样才能把相等的去掉
        while (lens > 0 && stack[lens - 1] <= head.val) {
            lens--;
        }
        int top = 0;
        if (lens - 1 >= 0) {
            top = stack[lens - 1];
        }
        // top即为此时的元素的右边第一个比他大的
        ans[index] = top;
        stack[lens++] =  head.val;
    }

    /**
     * 正向非回溯的做法，比较慢
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes1(ListNode head) {
        ListNode p = head;
        // 左左大小大
        int[] ans = new int[10000];
        int[][] s = new int[10000][2];
        int lens = 0;
        int index = 0;
        while (p != null) {
            while (lens > 0 && s[lens - 1][0] < p.val) {
                int v = s[lens - 1][0];
                int i = s[lens - 1][1];
                ans[i] = p.val;
                lens--;
            }
            s[lens][0] = p.val;
            s[lens][1] = index;
            lens++;
            p = p.next;
            index++;
        }
        int[] res = new int[index];
        System.arraycopy(ans, 0, res, 0, index);
        return res;
    }
}
