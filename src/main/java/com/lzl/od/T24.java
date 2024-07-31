package com.lzl.od;

import java.util.Scanner;

/**
 * 万能字符单词拼写
 *
 * @author LZL
 * @version 1.0
 * @since 2024/07/31
 */
public class T24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] words = new int[n][27];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            char[] charArray = s.toCharArray();
            words[i][26] = charArray.length;
            for (char c : charArray) {
                words[i][c - 'a']++;
            }
        }
        String s = sc.nextLine();
        char[] charArray = s.trim().toCharArray();
        int[] count = new int[28];
        int wn = 0;
        count[26]=charArray.length;
        for (char c : charArray) {
            if (c == '?') {
                count[27]++;
            } else {
                count[c - 'a']++;
            }
        }
        int res = 0;
        for (int[] word : words) {
            int flag = 0;
            if (word[26] > count[26] + count[27]) {
                continue;
            }
            for (int j = 0; j < word.length - 1; j++) {
                int c = word[j];
                if (c > 0) {
                    int hasC = count[j];
                    if (hasC < c) {
                        if (count[27] > 0 && count[27] > c - hasC) {
                            count[27] = count[27] - (c - hasC);
                        } else {
                            flag = 1;
                            break;
                        }
                    }
                }
            }
            if (flag == 0) {
                res++;
            }
        }
        System.out.println(res);
    }
}