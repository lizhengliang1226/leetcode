package com.lzl.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Wonderland
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r1 = a[0];
        int r3 = a[1];
        int r7 = a[2];
        int yr = a[3];
        List<Integer> dates = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int day = 365;
        int[] dp = new int[day + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Set<Integer> dd = new HashSet<>();

        for (int i = 0; i < dates.size(); i++) {
            dd.add(dates.get(i));
        }
        for (int i = 1; i <= day; i++) {
            if (dd.contains(i)) {
                int i1 = dp[i - 1] + r1;
                int i2 = dp[Math.max(0, i - 3)] + r3;
                int i3 = dp[Math.max(0, i - 7)] + r7;
                int i4 = dp[Math.max(0, i - 30)] + yr;
                dp[i] = Math.min(Math.min(i1, i2), Math.min(i3, i4));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[day]);
    }
}
