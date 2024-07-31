package com.lzl.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 按身高和体重排队
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T36 {
    private static class P {
        int height;
        int weight;
        int bh;

        public P(int height, int weight, int bh) {
            this.height = height;
            this.weight = weight;
            this.bh = bh;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<P> l = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int height = sc.nextInt();
            l.add(new P(height, 0, i + 1));
        }
        for (int i = 0; i < num; i++) {
            l.get(i).weight = sc.nextInt();
        }
        l.sort((a, b) -> {
            int i = a.height - b.height;
            if (i == 0) {
                int i1 = a.weight - b.weight;
                if (i1 == 0) {
                    return a.bh - b.bh;
                } else {
                    return i1;
                }
            } else {
                return i;
            }
        });
        System.out.println(l.stream().map(p -> String.valueOf(p.bh)).collect(Collectors.joining(" ")));
    }
}
