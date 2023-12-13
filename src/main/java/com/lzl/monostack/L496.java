package com.lzl.monostack;

import java.util.Arrays;

/**
 * 496. 下一个更大元素 I
 * 简单
 * 相关标签
 * 相关企业
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/13
 */
public class L496 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    /**
     * 朴素的写法，比单调栈还要快一点
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 左左大小大
        int[] index = new int[10000];
        int[] ans = new int[nums1.length];
        // 存储2的元素对应的索引
        for (int i = 0; i < nums2.length; i++) {
            int i1 = nums2[i];
            index[i1] = i;
        }
        // 遍历1元素
        for (int i = 0; i < nums1.length; i++) {
            // 拿到每个元素在2的索引
            int cur = nums1[i];
            int nums2Index = index[cur] + 1;
            // 从索引的下一个值开始往后遍历2
            for (; nums2Index < nums2.length; nums2Index++) {
                // 找到第一个大于当前元素的
                if (nums2[nums2Index] > cur) {
                    ans[i] = nums2[nums2Index];
                    // 一旦找到要结束循环
                    break;
                }
            }
            // 没找到则赋值为-1
            if (nums2Index == nums2.length) {
                ans[i] = -1;
            }
        }
        return ans;
    }

    /**
     * 单调栈的写法，已经很快了
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        // 左左大小大
        int[] index = new int[10000];
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        Arrays.fill(index, -1);
        for (int i = 0; i < nums1.length; i++) {
            int i1 = nums1[i];
            index[i1] = i;
        }
        int[] s = new int[nums2.length];
        int lens = 0;
        for (int i = 0; i < nums2.length; i++) {
            while (lens > 0 && nums2[s[lens - 1]] < nums2[i]) {
                int pop = nums2[s[lens - 1]];
                if (index[pop] != -1) {
                    ans[index[pop]] = nums2[i];
                }
                lens--;
            }
            s[lens++] = i;
        }
        return ans;
    }
}