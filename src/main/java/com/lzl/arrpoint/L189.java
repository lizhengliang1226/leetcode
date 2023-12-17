package com.lzl.arrpoint;

/**
 * 189. 轮转数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/17
 */
public class L189 {
    public static void main(String[] args) {
        new L189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 0);
        new L189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 1);
        new L189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        new L189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        new L189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
        new L189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 5);
        new L189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 6);
        new L189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        new L189().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 8);
        new L189().rotate(new int[]{-1, -100, 3, 99}, 2);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
