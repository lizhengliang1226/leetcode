package com.lzl;

/**
 * 5. 最长回文子串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class L5 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new L5().longestPalindrome(s));
//        System.out.println(longestPalindrome(s));
    }

    public String longestPalindrome1(String s) {
        int length = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            int l = extendPlain(s, i, i);
            int l1 = extendPlain(s, i, i + 1);
            int max = Math.max(l, l1);
            if (end - start < max) {
                if (max == l1) {
                    start = i - max / 2 + 1;
                } else {
                    start = i - max / 2;
                }
                end = start + max;
            }
        }
        return s.substring(start, end);
    }

    private int extendPlain(String s, int i, int i1) {
        while (i >= 0 && i1 < s.length() && s.charAt(i) == s.charAt(i1)) {
            i--;
            i1++;
        }
// 0 1 2 3 4 5 6 7 8 9
        return i1 - (i) - 1;
    }

    public String longestPalindrome(String s) {
        // base case 对于所有的单个字符，一定都是回文串
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int max = 0;
        int begin = 0;
        // 状态
        // 可生成的回文字串长度，1一定是回文，从2开始
        for (int L = 2; L <= n; L++) {
            // 左边界 j-i+1=L
            for (int i = 0; i < n; i++) {
                int j = L + i - 1;
                if (j > n - 1) continue;
                ;
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 > j - 1) {
                        dp[i][j] = true;
                    } else {

                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
