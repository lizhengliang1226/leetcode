package com.lzl.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 计算面积
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/01
 */
public class T37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        List<P> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            points.add(new P(X, Y));
        }
        int a = 0;
        int lx = 0;
        int ly = 0;
        points.add(new P(E, 0));
        for (int i = 0; i < points.size(); i++) {
            P p = points.get(i);
            if (i > 0) {
                int w = p.x - lx;
                int h = Math.min(p.y, ly);
                a += w * h;
            }
            lx = p.x;
            ly = p.y;
        }
        System.out.println(Math.abs(a));
    }

    private static class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}