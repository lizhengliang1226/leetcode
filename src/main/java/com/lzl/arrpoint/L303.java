package com.lzl.arrpoint;

/**
 * 303. 区域和检索 - 数组不可变
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * <p>
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/10
 */
public class L303 {
    public static void main(String[] args) {
        System.out.println(new NumArray(new int[]{1, 3, 5}).sumRange(1, 2));
    }
}

class NumArray {
    private int[] preSum;

    public NumArray(int[] nums) {
        preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right] - (left - 1 >= 0 ? preSum[left - 1] : 0);
    }
}