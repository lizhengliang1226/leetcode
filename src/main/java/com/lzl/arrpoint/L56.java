package com.lzl.arrpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 中等
 * 相关标签
 * 相关企业
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/15
 */
public class L56 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new L56().merge(new int[][]{new int[]{1, 2},new int[]{2, 4},new int[]{5, 6},new int[]{7, 8},new int[]{9, 10},})));
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int max = -1;
        int min = -1;
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] prev = intervals[i - 1];
            if (cur[0] <= max) {
                // 合并
                min = prev[0];
                max = Math.max(cur[1], prev[1]);
                continue;
            }
            int[] a = new int[]{min==-1?prev[0]:min, max==-1?prev[1]:max};
            res.add(a);
        }
        return res.toArray(new int[res.size()][2]);
    }
}