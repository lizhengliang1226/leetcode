package com.lzl.monostack;

import java.util.ArrayDeque;
import java.util.List;

/**
 * 2866. 美丽塔 II
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
 *
 * 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
 *
 * 如果以下条件满足，我们称这些塔是 美丽 的：
 *
 * 1 <= heights[i] <= maxHeights[i]
 * heights 是一个 山脉 数组。
 * 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
 *
 * 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
 * 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
 * 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。
 * @author lzl
 * @version 1.0
 * @since 2023/12/21
 */
public class L2866 {
    public static void main(String[] args) {
        System.out.println(new L2866().maximumSumOfHeights(List.of(5, 3, 4, 6,5,7,8,9, 1)));
    }
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int[] a = maxHeights.stream().mapToInt(i -> i).toArray();
        int n = a.length;
        long[] suf = new long[n + 1];
        var st = new ArrayDeque<Integer>();
        st.push(n); // 哨兵
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int x = a[i];
            while (st.size() > 1 && x <= a[st.peek()]) {
                int j = st.pop();
                sum -= (long) a[j] * (st.peek() - j); // 撤销之前加到 sum 中的
            }
            sum += (long) x * (st.peek() - i); // 从 i 到 st.peek()-1 都是 x
            suf[i] = sum;
            st.push(i);
        }

        long ans = sum;
        st.clear();
        st.push(-1); // 哨兵
        long pre = 0;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            while (st.size() > 1 && x <= a[st.peek()]) {
                int j = st.pop();
                pre -= (long) a[j] * (j - st.peek()); // 撤销之前加到 pre 中的
            }
            pre += (long) x * (i - st.peek()); // 从 st.peek()+1 到 i 都是 x
            ans = Math.max(ans, pre + suf[i + 1]);
            st.push(i);
        }
        return ans;
    }

}
