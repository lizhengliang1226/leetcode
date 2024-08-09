package com.lzl.slidewindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/30
 */
public class L438 {
    public static void main(String[] args) {
        System.out.println(new L438().findAnagrams("bcsssbcssscbjjbc", "bc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>(16);
        if (s.length() == 0) {
            return res;
        }
        if (s.length() < p.length()) {
            return res;
        }
        int left = 0, right = 0, valid = 0;
        int[] need = new int[26];
        int[] window = new int[26];
        int n = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (need[c - 'a'] == 0) {
                n++;
            }
            need[c - 'a'] += 1;
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            int index = c - 'a';
            if (need[index] != 0) {
                window[index] += 1;
                if (window[index] == need[index]) {
                    valid++;
                }
            }
            while (right - left == p.length() - 1) {
                if (valid == n) {
                    res.add(left);
                }
                char c1 = s.charAt(left);
                int i = c1 - 'a';
                if (need[i] != 0) {
                    if (window[i] == need[i]) {
                        valid--;
                    }
                    window[i] -= 1;
                }
                left++;
            }
            right++;
        }
        return res;
    }
}