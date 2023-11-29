package com.lzl.questions;

import java.util.LinkedList;

/**
 * 2336. 无限集中的最小数字
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
 * <p>
 * 实现 SmallestInfiniteSet 类：
 * <p>
 * SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
 * int popSmallest() 移除 并返回该无限集中的最小整数。
 * void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/29
 */
public class L2336 {
    public static void main(String[] args) {
        SmallestInfiniteSet q = new SmallestInfiniteSet();
        q.popSmallest();
        q.popSmallest();
        q.popSmallest();
        q.popSmallest();
        q.popSmallest();
        q.popSmallest();
        q.popSmallest();
        q.popSmallest();
        q.popSmallest();
        q.addEle(1);
        q.addEle(2);
        q.addEle(3);
        q.addEle(4);
        q.addEle(5);
        q.addEle(6);
        q.addEle(7);
        q.addEle(8);
        q.addEle(9);
        q.addEle(10);

    }
}

class SmallestInfiniteSet {
    private int min = 1;
    private LinkedList<Integer> res = new LinkedList<>();

    public SmallestInfiniteSet() {

    }

    public int popSmallest() {
        if (res.isEmpty()) {
            min++;
            return min - 1;
        }
        return res.removeFirst();
    }

    public void addBack(int num) {
        if (num >= min) {
            return;
        }
        if (res.contains(num)) {
            return;
        }
        addEle(num);

    }

    public void addEle(int num) {
        if (res.isEmpty()) {
            res.add(num);
            return;
        }
        int left = 0;
        int size = res.size();
        int right = size - 1;
        int mid = 0;
        int insertIndex = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            Integer midv = res.get(mid);
            if (midv == num) {
                insertIndex = mid;
                break;
            } else if (midv > num) {
                right = mid - 1;
                insertIndex = right + 1;
            } else {
                left = mid + 1;
                insertIndex = left;
            }
        }
        res.add(insertIndex, num);
    }
}