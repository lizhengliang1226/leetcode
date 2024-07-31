package com.lzl.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 执行任务赚积分
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[][] tasks = new int[N][2];
        List<Task> l = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            l.add(new Task(sc.nextInt(), sc.nextInt()));
        }
        l.sort((e, v) -> v.v - e.v);
        int sum = 0;
        boolean[] used = new boolean[T + 1];
        for (Task task : l) {
            for (int t = Math.min(task.sla, T); t > 0; t--) {
                if (!used[t]) {
                    sum += task.v;
                    used[t] = true;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    private static class Task {
        int sla;
        int v;

        public Task(int sla, int v) {
            this.sla = sla;
            this.v = v;
        }
    }
}
