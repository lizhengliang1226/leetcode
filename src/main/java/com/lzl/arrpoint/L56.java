package com.lzl.arrpoint;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

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
        System.out.println(Arrays.deepToString(new L56().merge(new int[][]{new int[]{1, 2}, new int[]{2, 4}, new int[]{5, 6}, new int[]{7, 8}, new int[]{9, 10},})));
    }

    /**
     * 排序后，不断更新有重叠的右区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] res = new int[intervals.length + 1][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || res[index][1] < interval[0]) {
                res[++index] = interval;
            } else {
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }

    TreeMap<Integer, Integer> t = new TreeMap<>();

    /**
     * 使用treemap的特性来做区间合并
     *
     * @param intervals
     * @return
     */
    public int[][] merge1(int[][] intervals) {
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            addInterval(left, right);
        }
        int[][] res = new int[t.size()][2];
        int c = 0;
        for (Map.Entry<Integer, Integer> e : t.entrySet()) {
            res[c++] = new int[]{e.getKey(), e.getValue()};
        }
        return res;
    }

    private void addInterval(int left, int right) {
        Map.Entry<Integer, Integer> e = t.floorEntry(right);
        while (e != null && e.getValue() >= left) {
            Integer l = e.getKey();
            Integer r = e.getValue();
            t.remove(l);
            left = Math.min(l, left);
            right = Math.max(r, right);
            e = t.floorEntry(right);
        }
        t.put(left, right);
    }
}