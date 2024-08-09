package com.lzl.questions;

/**
 * 3131. 找出与数组相加的整数 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个长度相等的数组 nums1 和 nums2。
 * <p>
 * 数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 * <p>
 * 在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 * <p>
 * 返回整数 x 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：nums1 = [2,6,4], nums2 = [9,7,5]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 与 3 相加后，nums1 和 nums2 相等。
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums1 = [10], nums2 = [5]
 * <p>
 * 输出：-5
 * <p>
 * 解释：
 * <p>
 * 与 -5 相加后，nums1 和 nums2 相等。
 * <p>
 * 示例 3:
 * <p>
 * 输入：nums1 = [1,1,1,1], nums2 = [1,1,1,1]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 与 0 相加后，nums1 和 nums2 相等。
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/08
 */
public class L3131 {
    public static void main(String[] args) {
        int[] nums1 = {2, 6, 4};
        int[] nums2 = {9, 7, 5};
        System.out.println(new L3131().addedInteger(nums1, nums2));
    }

    public int addedInteger(int[] nums1, int[] nums2) {
        // 因为min(nums1)+x=min(num2)
        // 所以x=min(nums2)-min(nums1)
        return min(nums2) - min(nums1);
    }

    private int min(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for (int i : nums1) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}