package com.lzl.arrpoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * <p>
 * 子数组是数组中元素的连续非空序列。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/14
 */
public class L560 {
    public static void main(String[] args) {
        System.out.println(new L560().subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int pre = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // 求前缀和，每次得到后问下之前有没有满足条件的前缀和，pre-k意思是，前面有没有一个前缀和等于这个，如果有，那么pre-前面那个和就等于k，得到一个子数组满足条件
        // 当然，前面的前缀和可能有一样的，所以map要记前面有几个这样的前缀和，取的时候就取所有的
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }


}
