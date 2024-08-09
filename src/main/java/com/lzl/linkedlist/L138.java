package com.lzl.linkedlist;


import com.lzl.util.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 随机链表的复制
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/18
 */
public class L138 {
    Map<Node, Node> visited = new HashMap<>();

    public static void main(String[] args) {
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);
        n7.next = n13;
        n13.next = n11;
        n11.next = n10;
        n10.next = n1;
        n7.random = null;
        n13.random = n7;
        n11.random = n1;
        n10.random = n11;
        n1.random = n7;
        new L138().copyRandomList(n7);
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            Node node = new Node(head.val);
            if (head.random != null) {
                node.random = node;
            }
            return node;
        }
        Node d = new Node(-1);
        dfs(head, d);
        return d.next;
    }

    /**
     * 递归的方法
     *
     * @param cur
     * @param copy
     */
    private void dfs(Node cur, Node copy) {
        if (cur == null) {
            return;
        }
        // 处理next
        copy.next = visited.containsKey(cur) ? visited.get(cur) : new Node(cur.val);
        // 维护新旧映射关系
        visited.put(cur, copy.next);
        // 处理random
        Node random = cur.random;
        if (random != null) {
            copy.next.random = visited.containsKey(random) ? visited.get(random) : (random == cur ? copy.next : new Node(random.val));
            // 维护新旧随机节点映射关系
            visited.put(cur.random, copy.next.random);
        }
        copy = copy.next;
        dfs(cur.next, copy);
    }

    /**
     * 另一种方法，迭代的方法
     *
     * @param head
     * @return
     */
    private Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }

        // 创建一个HashMap来存储访问过的节点和对应的复制节点
        Map<Node, Node> visited = new HashMap<>();

        // 创建原始链表的头节点和复制链表的头节点
        Node original = head;
        Node sentinel = new Node(original.val);

        // 将原始链表的头节点和复制链表的头节点放入visited中，建立映射关系
        visited.put(original, sentinel);

        // 复制链表的当前节点
        Node copyCurrent = sentinel;

        // 遍历原始链表
        while (original != null) {
            // 处理random指针
            if (original.random != null) {
                // 如果random指向的节点已经被复制过，则直接使用复制节点
                if (visited.containsKey(original.random)) {
                    copyCurrent.random = visited.get(original.random);
                } else {
                    // 否则，创建一个新的节点，并将其放入visited中，并建立映射关系
                    Node newRandom = new Node(original.random.val);
                    visited.put(original.random, newRandom);
                    copyCurrent.random = newRandom;
                }
            }

            // 处理next指针
            if (original.next != null) {
                // 如果next节点已经被复制过，则直接使用复制节点
                if (visited.containsKey(original.next)) {
                    copyCurrent.next = visited.get(original.next);
                } else {
                    // 否则，创建一个新的节点，并将其放入visited中，并建立映射关系
                    Node newNext = new Node(original.next.val);
                    visited.put(original.next, newNext);
                    copyCurrent.next = newNext;
                }
            }

            // 移动到下一个节点
            original = original.next;
            copyCurrent = copyCurrent.next;
        }

        return sentinel;
    }

}