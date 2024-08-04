package com.lzl.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 部门人力分配
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger sum = new AtomicInteger();
        List<Integer> req = new ArrayList<>();
        Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).forEach(i -> {
            max.set(Math.max(max.get(), i));
            sum.addAndGet(i);
            req.add(i);
        });
        int left = max.get();
        int right = sum.get();
        int N = req.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (can(M, req, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean can(int m, List<Integer> req, int mid) {
        int mu = 0;
        int i = 0;
        int N = req.size();
        while (i < N) {
            int cm = 0;
            int j = i;
            while (j < N && cm + req.get(j) <= mid && (j - i) < 2) {
                cm += req.get(j);
                j++;
            }
            mu++;
            i = j;
        }
        return mu <= m;
    }
}
