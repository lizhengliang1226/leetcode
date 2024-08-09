package com.lzl.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/07
 */
public class L1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = new L1().twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);

    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                result[0] = map.get(target - num);
                result[1] = i;
                return result;
            } else {
                map.put(num, i);
            }
        }
        return result;
    }
}