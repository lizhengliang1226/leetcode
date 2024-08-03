package com.lzl.od;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 数组去重排序
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Num> m = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int finalI = i;
            m.compute(array[i], (k, v) -> {
                if (v == null) {
                    return new Num(finalI, array[finalI], 1);
                } else {
                    v.c++;
                    return v;
                }
            });
        }
        System.out.println(m.values().stream().sorted((o1, o2) -> {
            int i = o2.c - o1.c;
            if (i == 0) {
                return o1.i - o2.i;
            } else {
                return i;
            }
        }).map(a -> String.valueOf(a.value)).collect(Collectors.joining(",")));
    }

    private static class Num {
        int i;
        int value;
        int c;

        public Num(int i, int value, int c) {
            this.i = i;
            this.value = value;
            this.c = c;
        }
    }
}
