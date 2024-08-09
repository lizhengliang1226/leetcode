package com.lzl.questions;

/**
 * 169. 多数元素
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/09
 */
public class L169 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new L169().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        int v = 0;
        int x = 0;
        // 摩尔投票法，先假设第一个元素为众数，然后遍历数组，如果遇到相同的元素，则票数+1，否则票数-1，直到票数为0，则重新开始计票，直到遍历完数组。
        for (int num : nums) {
            if (v == 0) x = num;
            v += num == x ? +1 : -1;
        }
        return x;
    }
}
