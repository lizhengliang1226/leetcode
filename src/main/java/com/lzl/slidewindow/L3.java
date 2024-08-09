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
        System.out.println(new L3().lengthOfLongestSubstring("cdd"));
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
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            char c = chars[right];
            window[c]++;
            // 出现重复字符，需要缩小窗口
            if (window[c] > 1) {
                flag = 1;
            } else {
                // 否则计算当前最大
                max = Math.max(max, right - left + 1);
            }
            while (flag == 1) {
                char d = chars[left];
                window[d]--;
                // 缩小后判断是否不再重复
                if (window[c] == 1) {
                    // 计算最大
                    max = Math.max(max, right - left);
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