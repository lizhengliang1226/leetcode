package com.lzl.arrpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/07
 */
public class L15 {
    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c
     * ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList(16);
        //去除部分重复
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int x = nums[i];
            int j = i + 1;
            int k = len - 1;// 最大的数
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 自己重复了，跳过
                continue;
            }
            if (x + nums[len - 1] + nums[len - 2] < 0) {
                // 当前数加上最大的两个数都还小于0，那么后面不可能有加起来能等于0的，直接结束此次循环
                continue;
            }
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                // 我加上我最近的两个数都大于0了，则后面所有的数怎么加都会大于0了，所以直接结束循环
                break;
            }
            while (j < k) {
                int sum = x + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    list.add(List.of(x, nums[j], nums[k]));
                    for (j++; j < k && nums[j] == nums[j - 1]; ++j)
                        ;
                    for (k--; k > j && nums[k] == nums[k + 1]; --k)
                        ;
                }
            }

        }
        return list;
    }
}