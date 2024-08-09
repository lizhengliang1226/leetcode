package com.lzl.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/28
 */
public class L76 {
    public String minWindow(String s, String t) {
        char[] ary = t.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : ary) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int LEN = Integer.MAX_VALUE;
        while (right < s.length()) {
            // 进入窗口
            char c = s.charAt(right);
            // 窗口值增加
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            // 扩大窗口
            right++;
            while (valid == need.size()) {
                if (right - left < LEN) {
                    LEN = right - left;
                    start = left;
                }
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (need.get(c1).equals(window.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.getOrDefault(c1, 0) - 1);
                }
            }
        }
        return LEN == Integer.MAX_VALUE ? "" : s.substring(start, start + LEN);
    }
}