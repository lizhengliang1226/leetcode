package com.lzl.slidewindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 尝试过
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/15
 */
public class L239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L239().maxSlidingWindow(new int[]{1, 5, 4, 8, 9, 6, 2, 3, -1}, 3)));
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> monoQueue = new LinkedList<>();
        // int[] nums = new int[]{1, 5, 4, 8, 9, 6, 2, 3, -1};
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
        return res;
    }
}