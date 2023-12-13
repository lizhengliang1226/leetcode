package com.lzl.diffarr;

import java.util.Arrays;

/**
 * 370.区间加法
 * 假设你有一个长度为n的数组，初始情况下所有的数字均为0，你将会被给出k个更新的操作。
 * 其中，每个操作会被表示为一个三元组：[startlndex,endIndex,inc,你需要将子数组A[startlndex.endlndex]（包括startIndex和
 * endlndex)t增加inc。
 * 请你返回k次操作后的数组。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/13
 */
public class L370 {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new L370().getModifiedArray(6, new int[][]{new int[]{0, 5, 3}, new int[]{1, 3, -10}, new int[]{3, 4, 7}})));
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] dif = new int[length];
        // 差分数组公式
        // a[i]=a[i-1]+dif[i]
        // dif[0]=a[0]
        for (int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            dif[start] += inc;
            if (end + 1 < length) {
                dif[end + 1] -= inc;
            }
        }
        int[] res = new int[length];
        res[0] = dif[0];
        for (int i = 1; i < dif.length; i++) {
            res[i] = res[i - 1] + dif[i];
        }
        return res;
    }
}