package com.lzl.monostack;

import java.util.Arrays;

/**
 * 503. 下一个更大元素 II
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/13
 */
public class L503 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L503().nextGreaterElements(new int[]{1, 2, 1})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] arr = duplicateArray(nums);
        int[] s = new int[arr.length];
        int lens = 0;
        Arrays.fill(res, -1);
        // 左左大小大
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            while (lens > 0 && arr[s[lens - 1]] < num) {
                int index = s[lens - 1];
                if (index >= n) {
                    index -= n;
                }
                res[index] = num;
                lens--;
            }
            s[lens++] = i;
        }
        return res;
    }

    public int[] duplicateArray(int[] array) {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        System.arraycopy(array, 0, newArray, array.length, array.length);
        return newArray;
    }
}