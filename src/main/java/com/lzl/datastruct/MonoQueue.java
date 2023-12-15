package com.lzl.datastruct;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调队列
 * 元素可以从两头删除，入队只能从队尾入队，且要保持单调性
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/15
 */
public class MonoQueue {
    public static void main(String[] args) {
        Deque<Integer> monoQueue = new LinkedList<>();
        int[] nums = new int[]{1, 5, 4, 8, 9, 6, 2, 3, -1};
        int k=3;
        int[] res = new int[nums.length - k + 1];
        // 维护两个索引，一个入队索引，一个出队索引，对于入队索引的元素不断入队即可
        // 出队索引初始化为1-k，这样在k次入队后就可以开始获取结果
        // 出队前判断当前出队值是否就是队列的最大值，如果是则出队，否则不出队
        for (int joinQueueIndex = 0, outQueueIndex = 1 - k; joinQueueIndex < nums.length; joinQueueIndex++, outQueueIndex++) {
            if (outQueueIndex > 0 && monoQueue.peekFirst() == nums[outQueueIndex - 1]) {
                monoQueue.pollFirst();
            }
            while (!monoQueue.isEmpty() && monoQueue.peekLast() < nums[joinQueueIndex]) {
                monoQueue.pollLast();
            }
            monoQueue.addLast(nums[joinQueueIndex]);
            // 关键点，要用>=0，这样在第一次准备出队时会先把最大值保存
            if (outQueueIndex >= 0) {
                res[outQueueIndex] = monoQueue.peekFirst();
            }
        }
        // return res;
    }


}