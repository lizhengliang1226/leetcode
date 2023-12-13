package com.lzl.monostack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，
 * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/13
 */
public class L739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(new L739().dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(new L739().dailyTemperatures(new int[]{30, 60, 90})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> s = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        // 左左大小大，从左往右遍历，push时找到左边第一个比自己大的元素，符号用小于，pop时找到pop元素右边第一个比自己大的元素
        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                // 对于pop，他的右边第一个比他大的数就是此时的i
                Integer pop = s.pop();
                ans[pop] = i - pop;
            }
            s.push(i);
        }
        return ans;
    }

}