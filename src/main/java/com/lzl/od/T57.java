package com.lzl.od;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 机器人仓库搬砖
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(a);
        Integer max = a.get(a.size() - 1);
        int left = 1;
        int right = max;
        int k = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean b = canBanWan(mid, a);
            if (b) {
                k = mid;
                right = mid - 1;
            } else if (!b) {
                left = mid + 1;
            }
        }
        System.out.println(k);
    }

    private static boolean canBanWan(int mid, List<Integer> a) {
        int t = 0;
        for (Integer i : a) {
            t += (int) Math.ceil(1.0 * i / mid);
        }
        return t <= 8;
    }
}
