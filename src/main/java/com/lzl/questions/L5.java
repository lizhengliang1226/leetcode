package com.lzl.questions;

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

    public String longestPalindrome(String s) {
        int start=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int l1=extendPlain1(s,i,i);
            int l2=extendPlain1(s,i,i+1);
            int max1 = Math.max(l1, l2);
            if(max1>max){
                max=max1;
                // 公式：不管max是单数还是双数，算出来都是正确的起始位置
                // start=i-(max-1)/2;
                start=i-(max1-1)/2;
            }
        }
        return s.substring(start,start+max);
    }

    private int extendPlain1(String s, int left, int right) {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        // 满足条件前还会再进一次while，所以要减一
        return right-left-1;
    }


    public String longestPalindrome1(String s) {
        int length = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            int l1 = extendPlain(s, i, i);
            int l2 = extendPlain(s, i, i + 1);
            int max = Math.max(l1, l2);
            if (end - start < max) {
                if (max == l2) {
                    start = i - max / 2 + 1;
                } else {
                    start = i - max / 2;
                }
                end = start + max;
            }
        }
        return s.substring(start, end);
    }

    private int extendPlain(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 在最后一次满足条件时会left--和right++，所以计算这个长度这里要减一
        return right - left - 1;
    }

    public String longestPalindrome2(String s) {
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