package com.lzl.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 内存冷热标记
 * <p>
 * 10
 * 1 2 1 2 1 2 1 2 1 2
 * 5
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[65536];
        sc.nextLine();
        String s = sc.nextLine();
        int cou = sc.nextInt();
        int[] array = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int y = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            a[array[i]]++;
            if (a[array[i]] >= cou) {
                y++;
                l.add(array[i]);
            }
        }
        System.out.println(y);
        l.sort(Integer::compare);
        for (Integer i : l) {
            System.out.println(i);
        }
    }
}
