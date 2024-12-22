package com.lzl.bintree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 315. 计算右侧小于当前元素的个数
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 * <p>
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * @author lzl
 * @version 1.0
 * @since 2024/12/22
 */
public class L315 {
    private int[] count;

    record Pair(int num, int index) {
    }

    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        temp = new Pair[nums.length];
        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        mergeSort(arr, 0, nums.length - 1);
        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }

    private void mergeSort(Pair[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private Pair[] temp;

    private void merge(Pair[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j >= hi + 1) {
                nums[k] = temp[i++];
                count[nums[k].index()] += j - mid - 1;
            } else if (temp[i].num > temp[j].num) {
                nums[k] = temp[j++];
            } else {
                nums[k] = temp[i++];
                count[nums[k].index()] += j - mid - 1;
            }

        }
    }

}
