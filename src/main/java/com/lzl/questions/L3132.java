package com.lzl.questions;

import java.util.Arrays;

/**
 * 3132. 找出与数组相加的整数 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数数组 nums1 和 nums2。
 * <p>
 * 从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 * <p>
 * 执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 * <p>
 * 返回能够实现数组相等的 最小 整数 x 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：nums1 = [4,20,16,12,8], nums2 = [14,18,10]
 * <p>
 * 输出：-2
 * <p>
 * 解释：
 * <p>
 * 移除 nums1 中下标为 [0,4] 的两个元素，并且每个元素与 -2 相加后，nums1 变为 [18,14,10] ，与 nums2 相等。
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums1 = [3,5,5,3], nums2 = [7,7]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 移除 nums1 中下标为 [0,3] 的两个元素，并且每个元素与 2 相加后，nums1 变为 [7,7] ，与 nums2 相等。*
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/09
 */
public class L3132 {
    public static void main(String[] args) {
        int[] nums1 = {4, 20, 16, 12, 8};
        int[] nums2 = {14, 18, 10};
        System.out.println(new L3132().minimumAddedInteger(nums1, nums2));
        int[] nums3 = {3, 5, 5, 3};
        int[] nums4 = {7, 7};
        System.out.println(new L3132().minimumAddedInteger(nums3, nums4));
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int x = 0;
        int[] nums3 = new int[nums1.length];
        // 以下理论基于nums1 num2排序了
        // 删除两个元素后剩下的与x相加后等于nums2
        // 那么一定会保留nums1前三个元素的其中一个
        // 根据公式x=min(nums2)-min(nums1)此时就是x=nums2[0]-nums[i] 其中i=0,1,2，如果保留的是nums1[3]那么0 1 2一定已经被删除了，不符合题意
        // 所以遍历前三个元素，求出x后确认nums2是不是nums1在加上x后的子序列
        // 由于x要最小所以从第三个元素开始遍历，找到即可直接返回
        for (int i = 2; i >= 0; i--) {
            x = nums2[0] - nums1[i];
            int n2 = 0;
            for (int k = i; k < nums1.length; k++) {
                if (nums1[k] + x == nums2[n2] && ++n2 == nums2.length) {
                    return x;
                }
            }
        }
        return x;
    }
}