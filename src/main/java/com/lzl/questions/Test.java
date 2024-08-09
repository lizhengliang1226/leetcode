package com.lzl.questions;

/**
 * @author LZL
 * @version 1.0
 * @since 2024/08/09
 */
public class Test {
    public static void main(String[] args) {

        String s = "bba";
        String t = "ab";
        String result = new Test().minWindow(s, t);
        System.out.println(result);
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] need = new int[130];
        int kindOfChars = 0;
        for (char c : tc) {
            if (need[c] == 0) {
                kindOfChars++;
            }
            need[c]++;
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int valid = 0;
        int[] win = new int[130];
        while (right < sc.length) {
            win[sc[right]]++;
            if (win[sc[right]] == need[sc[right]]) {
                valid++;
            }
            while (valid == kindOfChars) {
                int curLen = right - left;
                if (curLen < minLen) {
                    minLen = curLen;
                    start = left;
                }
                win[sc[left]]--;
                if (need[sc[left]] != 0 && win[sc[left]] < need[sc[left]]) {
                    valid--;
                }
                left++;
            }
            right++;
        }
        if (minLen == Integer.MIN_VALUE) {
            return "";
        }
        return s.substring(start, start + minLen + 1);
    }
}
