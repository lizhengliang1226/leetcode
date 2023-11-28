package com.lzl.questions;

/**
 * 1670. 设计前中后队列
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 * <p>
 * 请你完成 FrontMiddleBack 类：
 * <p>
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 * <p>
 * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/28
 */
public class L1670 {
    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushMiddle(874835);
        q.popBack();
        q.popMiddle();
        q.popMiddle();
        q.pushBack(319750);
        q.pushFront(782168);
        q.popFront();
        q.pushMiddle(16473);
        q.pushMiddle(495349);
        q.popMiddle();
        q.popMiddle();
        q.pushMiddle(596131);
        q.popMiddle();
        q.pushMiddle(583563);
    }
}

class FrontMiddleBackQueue {
    private int size;
    private Node head;
    private Node tail;
    private Node mid;

    public FrontMiddleBackQueue() {
        head = new Node();
        tail = new Node();
        mid = new Node();
    }

    public void pushFront(int val) {
        Node cur = new Node();
        cur.val = val;
        if (size == 0) {
            init(cur);
            size++;
            return;
        }
        Node h = head.next;
        head.next = cur;
        cur.next = h;
        h.prev = cur;
        cur.prev = head;
        // 单，左移一个 双，不动
        if (size % 2 != 0) {
            mid.next = mid.next.prev;
        }
        size++;
    }

    private void init(Node cur) {
        head.next = cur;
        cur.prev = head;
        mid.next = cur;
        tail.next = cur;
        cur.next = tail;
    }

    public void pushMiddle(int val) {
        Node cur = new Node();
        cur.val = val;
        if (size == 0) {
            init(cur);
            size++;
            return;
        }
        Node m = mid.next;
        mid.next = cur;
        if (size % 2 == 0) {
            // 往右移动一位
            Node next = m.next;
            move(m, cur, next);
        } else {
            // 往左移动一位
            Node prev = m.prev;
            move(prev, cur, m);
        }
        size++;
    }

    private void move(Node prev, Node cur, Node next) {
        prev.next = cur;
        cur.prev = prev;
        cur.next = next;
        next.prev = cur;
    }

    public void pushBack(int val) {
        Node cur = new Node();
        cur.val = val;
        if (size == 0) {
            init(cur);
            size++;
            return;
        }
        Node t = tail.next;
        t.next = cur;
        cur.prev = t;
        tail.next = cur;
        cur.next = tail;
        if (size % 2 == 0) {
            mid.next = mid.next.next;
        }
        size++;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        Node h = head.next;
        head.next = h.next;
        h.next.prev = head;
        mid.next = size % 2 == 0 ? mid.next.next : mid.next;
        h.next = null;
        size--;
        return h.val;
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        Node m = mid.next;
        Node prev = m.prev;
        Node next = m.next;
        mid.next = size % 2 == 0 ? next : prev;
        prev.next = next;
        next.prev = prev;
        m.next = null;
        m.prev = null;
        size--;
        return m.val;
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        Node t = tail.next;
        Node prev = t.prev;
        prev.next = tail;
        tail.next = prev;
        mid.next = size % 2 == 0 ? mid.next : mid.next.prev;
        t.prev = null;
        t.next = null;
        size--;
        return t.val;
    }

    private static class Node {
        private int val;
        private Node prev;
        private Node next;
    }
}