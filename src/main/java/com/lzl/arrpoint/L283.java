package com.lzl.arrpoint;

/**
 * 283. 移动零
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/10
 */
public class L283 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        if (nums.length == 1) return;
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                // 023450123
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = 0;
        }
    }
}
