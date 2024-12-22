package com.lzl.bintree;

/**
 * 912. 排序数组
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 *
 * @author lzl
 * @version 1.0
 * @since 2024/12/22
 */
public class L912 {
    private int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == hi + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j++];
            } else {
                nums[k] = temp[i++];
            }
        }
    }
}
