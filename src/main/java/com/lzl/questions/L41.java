package com.lzl.questions;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/04
 */
public class L41 {
    public static void main(String[] args) {

        int[] nums = {2, 1};
        int result = new L41().firstMissingPositive(nums);
        System.out.println(result);
    }

    /**
     * 官方解法
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        // 生成一种带标记的hash表
        for (int i = 0; i < n; i++) {
            // 第一步，把所有小于等于0的全部设置为N+1，也就是长度加一
            if (nums[i] <= 0) nums[i] = n + 1;
        }
        // 第二步，对于每个小于N的值，就把他当作坐标去给对应坐标的值打标记，标记方式为设置该值为负数
        for (int i = 0; i < n; i++) {
            // 所以取值时要取绝对值，因为可能当前值被其他的值打了标记
            int num = Math.abs(nums[i]);
            // 如果当前值在数组长度范围内，则可以作为坐标，给对应坐标的值打标记
            if (num <= n) {
                // 打标记，把对应坐标的值设置为负数
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 第三步，遍历打完标记的值，如果有大于0的，说明没有标记，则就没有那个对应坐标的值，所以直接返回
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 如果上面没返回，说明所有的标记都打了，则全部都有，那就返回N+1
        return n + 1;
        // 注意：那些在第一步被设置为N+1的值也会被存在的值打上标记的
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        // 遍历，把不在[1,len]的都置为len+1
        for (int i = 0; i < len; i++) {
            if (nums[i] < 1 || nums[i] > len) {
                nums[i] = len + 1;
            }
        }
        // 遍历，把对应位置的值置为负数
        for (int i = 0; i < len; i++) {
            // 打标记的位置
            int index = Math.abs(nums[i]);
            // 前一个位置在索引范围内
            if (index - 1 >= 0 && index - 1 <= len - 1) {
                // 未被标记过
                if (nums[index - 1] > 0) {
                    // 打标记
                    nums[index - 1] = -nums[index - 1];
                }
            }
        }
        // 遍历，一旦有没打标记的，则直接返回位置加1
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 没有则返回len+1
        return len + 1;
    }

    /**
     * 自己想的笨办法
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        if (nums.length == 0) return 1;
        if (nums.length == 1) {
            if (nums[0] == 1) return 2;
            return 1;
        }
        Arrays.sort(nums);
        int flag = 0;
        int point = 0;
        // 是否包含1的这个标志
        int contain1Flag = 0;
        // 下界
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 小于1的直接过滤
            if (num < 1) {
                continue;
            }
            // 包含1，设置一下标记
            if (num == 1) {
                contain1Flag = 1;
            }
            // 防止越界
            if (i == nums.length - 1) break;
            // 对于重复的值也直接跳过
            if (num == nums[i + 1]) {
                continue;
            }
            // 判断是否连续
            if (num + 1 == nums[i + 1]) {
                // 连续
            } else {
                // 不连续则直接断掉
                flag = 1;
                // 记录断点
                point = nums[i];
                break;
            }
        }
        // 不包含1，则直接返回1，因为1是最小的
        if (contain1Flag == 0) {
            return 1;
        }
        // 有断点则直接在断点加一返回
        if (flag == 1) {
            return point + 1;
        }
        // 最后，是含1且连续的，则直接取最后一个值加1得到不包含的最小整数
        return nums[nums.length - 1] + 1;
    }
}
