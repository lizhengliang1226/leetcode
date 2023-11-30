package com.lzl.slidewindow;

/**
 * 3. 无重复字符的最长子串
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/30
 */
public class L3 {
    public static void main(String[] args) {
        System.out.println(new L3().lengthOfLongestSubstring("aab"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int max = 0;
        int[] window = new int[1000];
        // 控制窗口的缩放
        int flag = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 窗口缩小的判断条件，如果某个字符次数超过了1，则要开始缩小窗口
            if (window[c] != 0) {
                flag = 1;
            }
            window[c] += 1;
            while (flag == 1) {
                // 计算当前最大
                max = Math.max(max, right - left);
                char c1 = s.charAt(left);
                window[c1] -= 1;
                // 当窗口中的字符数缩小到了1，则没有重复字符了，那就继续扩大窗口
                if (window[c1] == 1) {
                    flag = 0;
                }
                left++;
            }
            right++;
        }
        max = Math.max(max, right - left);
        return max;
    }
}