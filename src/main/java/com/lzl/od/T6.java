package com.lzl.od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 分配土地
 */
public class T6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        Map<Integer, int[]> minPos = new HashMap<>();
        Map<Integer, int[]> maxPos = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = b[i][j];
                if (!minPos.containsKey(num)) {
                    minPos.put(num, new int[]{i, j});
                    maxPos.put(num, new int[]{i, j});
                } else {
                    minPos.get(num)[0] = Math.min(i, minPos.get(num)[0]);
                    minPos.get(num)[1] = Math.min(j, minPos.get(num)[1]);
                    maxPos.get(num)[0] = Math.max(i, maxPos.get(num)[0]);
                    maxPos.get(num)[1] = Math.max(j, maxPos.get(num)[1]);
                }
            }
        }
        int max = 0;
        for (Map.Entry<Integer, int[]> entry : minPos.entrySet()) {
            Integer num = entry.getKey();
            int[] mp = entry.getValue();
            int[] mxp = maxPos.get(num);
            int area = (mxp[0] - mp[0] + 1) * (mxp[1] - mp[1] + 1);
            max = Math.max(max, area);
        }
        System.out.println(max);
    }
}