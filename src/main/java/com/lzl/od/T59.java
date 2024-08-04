package com.lzl.od;

import java.io.FilterOutputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 传递悄悄话
 * 0 9 20 -1 -1 15 7 -1 -1 -1 -1 3 2*
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] collect = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int res = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            int l = 2 * cur + 1;
            int r = 2 * cur + 2;
            if (l < collect.length && collect[l] != -1) {
                collect[l] += collect[cur];
                queue.offer(l);
                if (collect[l] > res) {
                    res = collect[l];
                }
            }
            if (r < collect.length && collect[r] != -1) {
                collect[r] += collect[cur];
                queue.offer(r);
                if (collect[r] > res) {
                    res = collect[r];
                }
            }
        }
        System.out.println(res);
    }
}
