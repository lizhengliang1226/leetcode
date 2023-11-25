package com.lzl;

/**
 * 35. 搜索插入位置
 *
 * @author LZL
 * @version v1.0
 * @date 2022/7/18-17:50
 */
public class Num35  {

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，
     * 并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid=(left + right)/2;

        return 0;
    }

    public static void main(String[] args) {
        final Num35 num35 = new Num35();
        final int i = num35.searchInsert(new int[]{1, 2, 3, 4, 5, 6}, 4);
        System.out.println(i);
    }
}