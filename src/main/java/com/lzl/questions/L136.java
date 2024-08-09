package com.lzl.questions;

/**
 * 136. 只出现一次的数字
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 * <p>
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/09
 */
public class L136 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        int singleNumber = new L136().singleNumber(nums);
        System.out.println(singleNumber);
    }

    public int singleNumber(int[] nums) {
        // 异或运算，相同为0，不同为1，最终会剩下那个只出现一次的数字
        int ans = 0;
        for (int num : nums)
            ans ^= num;
        return ans;
    }
}
