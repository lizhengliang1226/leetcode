package com.lzl.diffarr;

import java.util.Arrays;

/**
 * 1109. 航班预订统计
 * 中等
 * 相关标签
 * 相关企业
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * @author lzl
 * @version 1.0
 * @since 2023/12/20
 */
public class L1109 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L1109().corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)));
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff=new int[n];
        for (int[] booking : bookings) {
            diff[ booking[0] - 1] += booking[2];
            if (booking[1] < n) diff[booking[1]] -= booking[2];
        }
        for (int i = 1; i < n; i++) {
            diff[i]+=diff[i-1];
        }
        return diff;
    }
}
