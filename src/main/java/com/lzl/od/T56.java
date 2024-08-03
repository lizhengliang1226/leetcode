package com.lzl.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小明找位置
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/03
 */
public class T56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int tall = Integer.parseInt(sc.nextLine());
        int left = 0, right = array.length;
        int index = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == tall) {
                index = mid;
                break;
            } else if (array[mid] < tall) {
                left = mid+1;
                index = mid+1;
            } else {
                right = mid;
                index = mid;
            }
        }
        System.out.println(index+1);
    }
}
