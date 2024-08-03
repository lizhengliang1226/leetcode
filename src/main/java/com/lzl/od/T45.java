package com.lzl.od;

import java.util.*;

/**
 * 精准核酸检测
 * <p>
 * 5
 * 1,2
 * 1 1 0 1 0
 * 1 1 0 0 0
 * 0 0 1 0 1
 * 1 0 0 1 0
 * 0 0 1 0 1
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] array = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[][] f = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int i1 = sc.nextInt();
                f[i][j] = i1;
            }
        }
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (f[i][j] == 1) {
                    l.get(i).add(j);
                }
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vi = new boolean[N];
        for (int i = 0; i < array.length; i++) {
            q.offer(array[i]);
            vi[array[i]] = true;
        }
        int c = 0;
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            List<Integer> integers = l.get(poll);
            for (int i = 0; i < integers.size(); i++) {
                int j = integers.get(i);
                if (!vi[j]) {
                    c++;
                    q.offer(j);
                    vi[j] = true;
                }
            }
        }

        System.out.println(c);
    }
}
