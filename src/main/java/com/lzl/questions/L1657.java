package com.lzl.questions;

import java.util.Arrays;

/**
 * 1657. 确定两个字符串是否接近
 * 提示
 * 中等
 * 89
 * 相关企业
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * <p>
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * <p>
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/30
 */
public class L1657 {
    public static void main(String[] args) {
        new L1657().closeStrings("abc", "bca");
    }

    public boolean closeStrings(String word1, String word2) {
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            w1[c - 'a'] += 1;
        }
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            w2[c - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if ((w1[i] > 0 && w2[i] == 0) || (w2[i] > 0 && w1[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(w1);
        Arrays.sort(w2);
        return Arrays.equals(w1, w2);
    }
}