package com.lzl;

/**
 * 1492. n 的第 k 个因子
 * 提示
 * 中等
 * 44
 * 相关企业
 * 给你两个正整数 n 和 k 。
 *
 * 如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n 的因子。
 *
 * 考虑整数 n 的所有因子，将它们 升序排列 。请你返回第 k 个因子。如果 n 的因子数少于 k ，请你返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12, k = 3
 * 输出：3
 * 解释：因子列表包括 [1, 2, 3, 4, 6, 12]，第 3 个因子是 3 。
 * 示例 2：
 *
 * 输入：n = 7, k = 2
 * 输出：7
 * 解释：因子列表包括 [1, 7] ，第 2 个因子是 7 。
 * 示例 3：
 *
 * 输入：n = 4, k = 4
 * 输出：-1
 * 解释：因子列表包括 [1, 2, 4] ，只有 3 个因子，所以我们应该返回 -1 。
 */
public class L1492 {
    public static void main(String[] args) {
        L1492 l1492 = new L1492();
        System.out.println(l1492.kthFactor(12, 3));
    }
    public int kthFactor(int n, int k) {
        // if(n==0)
        int cusor=0;
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                cusor++;
                if(cusor==k){
                    return i;
                }
            }
        }
        return -1;
    }
}