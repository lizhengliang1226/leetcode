package com.lzl.questions;

/**
 * 466. 统计重复个数
 * 困难
 * 相关标签
 * 相关企业
 * 定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。
 * <p>
 * 例如，str == ["abc", 3] =="abcabcabc" 。
 * 如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
 * <p>
 * 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。
 * 现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, n2] 。
 * <p>
 * 请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。
 *
 * @author lzl
 * @version 1.0
 * @since 2024/01/02
 */
public class L466 {
    public static void main(String[] args) {
        System.out.println(new L466().getMaxRepetitions("abc", 10, "bc", 2));
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        String str1 = getStr(s1, n1);
        String str2 = getStr(s2, n2);
        int l1 = str1.length();
        int l2 = str2.length();
        int max = l1 / l2;
        for (int i = max; i >= 0; i--) {
            String str = getStr(str2, i);
            boolean b = canGet(str1, str);
            if (b) {
                return i;
            }
        }
        return 0;
    }

    private boolean canGet(String src, String target) {
        int sStart = 0;
        boolean match = false;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int cs = sStart;
            for (int j = sStart; j < src.length(); j++) {
                if (c == src.charAt(j)) {
                    if (i == target.length() - 1) {
                        match = true;
                    }
                    sStart = j + 1;
                    break;
                }
            }
            if (cs == sStart) {
                break;
            }
        }
        return match;
    }

    private String getStr(String s1, int n1) {
        return s1.repeat(n1);
    }
}