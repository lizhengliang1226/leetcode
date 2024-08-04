package com.lzl.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 信道分配
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/04
 */
public class T66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int[] channel = new int[R + 1];
        for (int i = 0; i <= R; i++) {
            int num = sc.nextInt();
            channel[i] = num;
        }
        int D = sc.nextInt();
        List<int[]> channelList = new ArrayList<>();
        for (int i = R; i >= 0; i--) {
            int cap = (int) Math.pow(2, i);
            if (channel[i] > 0) {
                channelList.add(new int[]{cap, channel[i]});
            }
        }
        int uc = 0;
        while (true) {
            int rmc = D;
            for (int[] c : channelList) {
                int cap = c[0];
                int nums = c[1];
                int use = Math.min(rmc / cap, nums);
                rmc -= use * cap;
                if (rmc <= 0) {
                    break;
                }
            }
            if (rmc > 0) {
                break;
            }
            int g = D;
            for (int[] ints : channelList) {
                int cap = ints[0];
                int nums = ints[1];
//                int need = g / cap;
                int need = (int) Math.ceil(1.0 * g / cap);
                if (nums >= need) {
                    nums -= need;
                    need = 0;
                } else {
                    nums = 0;
                    need -= nums;
                }
                ints[1] = nums;
                if (need == 0) {
                    break;
                } else {
                    g = need * cap;
                }
            }
            uc++;
        }
        System.out.println(uc);

    }
}
