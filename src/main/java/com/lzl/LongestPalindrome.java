package com.lzl;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 *对于一个子串而言，如果它是回文串，并且长度大于 222，那么将它首尾的两个字母去除之后，它仍然是个回文串。例如对于字符串 “ababa”\textrm{``ababa''}“ababa”，如果我们已经知道 “bab”\textrm{``bab''}“bab” 是回文串，那么 “ababa”\textrm{``ababa''}“ababa” 一定是回文串，这是因为它的首尾两个字母都是 “a”\textrm{``a''}“a”。
 *
 * 根据这样的思路，我们就可以用动态规划的方法解决本题。我们用 P(i,j)P(i,j)P(i,j) 表示字符串 sss 的第 iii 到 jjj 个字母组成的串（下文表示成 s[i:j]s[i:j]s[i:j]）是否为回文串：
 *
 * P(i,j)={true,如果子串Si…Sj是回文串false,其它情况P(i,j) = \begin{cases} \text{true,} &\quad\text{如果子串~} S_i \dots S_j \text{~是回文串}\\ \text{false,} &\quad\text{其它情况} \end{cases}
 * P(i,j)={
 * true,
 * false,
 *
 *
 * 如果子串S
 * i
 *
 *  …S
 * j
 *
 *  是回文串
 * 其它情况
 *
 *
 * 这里的「其它情况」包含两种可能性：
 *
 * s[i,j]s[i, j]s[i,j] 本身不是一个回文串；
 *
 * i>ji > ji>j，此时 s[i,j]s[i, j]s[i,j] 本身不合法。
 *
 * 那么我们就可以写出动态规划的状态转移方程：
 *
 * P(i,j)=P(i+1,j−1)∧(Si==Sj)P(i, j) = P(i+1, j-1) \wedge (S_i == S_j)
 * P(i,j)=P(i+1,j−1)∧(S
 * i
 *
 *  ==S
 * j
 *
 *  )
 * 也就是说，只有 s[i+1:j−1]s[i+1:j-1]s[i+1:j−1] 是回文串，并且 sss 的第 iii 和 jjj 个字母相同时，s[i:j]s[i:j]s[i:j] 才会是回文串。
 *
 * 上文的所有讨论是建立在子串长度大于 222 的前提之上的，我们还需要考虑动态规划中的边界条件，即子串的长度为 111 或 222。对于长度为 111 的子串，它显然是个回文串；对于长度为 222 的子串，只要它的两个字母相同，它就是一个回文串。因此我们就可以写出动态规划的边界条件：
 *
 * {P(i,i)=trueP(i,i+1)=(Si==Si+1)\begin{cases} P(i, i) = \text{true} \\ P(i, i+1) = ( S_i == S_{i+1} ) \end{cases}
 * {
 * P(i,i)=true
 * P(i,i+1)=(S
 * i
 *
 *  ==S
 * i+1
 *
 *  )
 *
 *
 * 根据这个思路，我们就可以完成动态规划了，最终的答案即为所有 P(i,j)=trueP(i, j) = \text{true}P(i,j)=true 中 j−i+1j-i+1j−i+1（即子串长度）的最大值。注意：在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的，因此一定要注意动态规划的循环顺序。
 *

 * @author LZL
 * @version v1.0
 * @date 2022/8/9-14:36
 *
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        // 初始窗口大小为1，长度为1
        // base case
        int length = s.length();
        boolean[][] dp=new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i]=true;
        }

        return null;
    }
}