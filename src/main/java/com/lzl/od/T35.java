package com.lzl.od;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 测试用例执行计划
 * <p>
 * 5 4
 * 10
 * 20
 * 30
 * 40
 * 50
 * 1 2 3 0
 * 2 4 0
 * 1 5 0
 * 3 4 5 0
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T35 {
    private static class TestCase {
        int pro;
        int id;

        public TestCase(int pro, int id) {
            this.pro = pro;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] f = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int i1 = sc.nextInt();
            f[i] = i1;
        }
        List<TestCase> l = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int pro = 0;
            while (sc.hasNextInt()) {
                int i1 = sc.nextInt();
                if (i1 == 0) break;
                pro += f[i1];
            }
            l.add(new TestCase(pro, i));
        }
        l.sort((a, b) -> {
            if (a.pro != b.pro) {
                return b.pro - a.pro;
            } else {
                return a.id - b.id;
            }
        });
        for (TestCase t : l) {
            System.out.println(t.id);
        }

    }
}
