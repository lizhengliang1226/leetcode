package com.lzl.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 攀登者1
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/01
 */
public class T39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int r = 0;
        int N = arr.length;
        List<M> list = new ArrayList<>();
        while (r < arr.length) {
            M m = new M();
            int start = r;
            while (start < N - 1 && arr[start] >= arr[start + 1]) {
                start++;
            }
            int end = start + 1;
            while (end < N && arr[end] > arr[end - 1]) {
                end++;
            }
            if (end == N) {
                break;
            }
            //0,1,4,3,1,0,0,1,2,3,1,2,1,0
            m.start = start;
            m.end = end - 1;
            m.h = arr[end - 1];
            r = end;
            list.add(m);
        }
        System.out.println(list.size());

    }

    private static class M {
        int start;
        int end;
        int h;
    }
}