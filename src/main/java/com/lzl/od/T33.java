package com.lzl.od;

import java.util.Scanner;

/**
 * 堆内存申请
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        sc.nextLine();
        String str = "";
        int[] a = new int[100];
        while (!(str = sc.nextLine()).isEmpty()) {
            String[] split = str.split(" ");
            int start = Integer.parseInt(split[0]);
            int num = Integer.parseInt(split[1]);
            a[start] = num;
        }
        int r = 0;
        int min = Integer.MAX_VALUE;
        int res = -1;
        while (r < 100) {
            int s = r;
            if (a[r] == 0) {
                while (r < 100 && a[r] == 0) {
                    r++;
                }
                if (r - s >= value) {
                    int g = r - s - value;
                    if (g == 0) {
                        System.out.println(s);
                        return;
                    } else {
                        if(g<min){
                            min=g;
                            res=s;
                        }
                    }
                } else {
                    r += a[r] ;
                }

            }else{
                r += a[r] ;
            }
        }
        System.out.println(res);
    }
}
