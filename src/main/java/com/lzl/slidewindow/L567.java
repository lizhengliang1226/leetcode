package com.lzl.slidewindow;

/**
 * 567. 字符串的排列
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/30
 */
public class L567 {
    public static void main(String[] args) {
        System.out.println(new L567().checkInclusion("abc", "ccbbaacbac"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()==0)return false;
        if(s2.length()<s1.length())return false;
        int left = 0;
        int right = 0;
        int valid = 0;
        int[] need = new int[26];
        int[] window = new int[26];
        int n = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (need[c - 'a'] == 0) {
                n += 1;
            }
            need[c - 'a'] += 1;
        }
        while (right < s2.length()) {
            // 进入窗口
            char c = s2.charAt(right);
            // 取索引
            int i = c - 'a';
            // 需要的字符不为0，则要加一
            if (need[i] != 0) {
                // 窗口多了一个有用字符
                window[i] += 1;
                // 当前字符数等于需要字符数，有效数加加
                if (window[i] == need[i]) {
                    valid++;
                }
            }
            // 固定窗口大小为需要的字符长度，查看窗口中的字符是否是需要的全部字符，由于是全排列，只看个数，不看顺序
            while (right - left == s1.length() - 1) {
                // 有效字符与需要字符数相等，则找到
                if (valid == n) {
                    return true;
                }
                // 取出窗口值，此字符现在要出窗口，如果是需要的字符，则要把有效数减一
                char c1 = s2.charAt(left);
                int i1 = c1 - 'a';
                // 是需要的字符，此时减少了
                if (need[i1] != 0) {
                    if (window[i1] == need[i1]) {
                        valid--;
                    }
                    window[i1] -= 1;
                }
                left++;
            }
            // 扩大窗口
            right++;
        }
        return false;
    }
}