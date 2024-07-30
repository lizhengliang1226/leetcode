package com.lzl.od;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 整数对最小和
 */
public class T14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int j = 0; j < m; j++) {
            arr2[j] = sc.nextInt();
        }
        int k = sc.nextInt();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                result.add(arr1[i] + arr2[j]);
            }
        }
        result.sort(Comparator.comparingInt(o -> o));
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum+=result.get(i);
        }
        System.out.println(sum);


    }
}
