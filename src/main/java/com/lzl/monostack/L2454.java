package com.lzl.monostack;

import java.util.*;

/**
 * 2454. 下一个更大元素 IV
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的非负整数数组 nums 。对于 nums 中每一个整数，你必须找到对应元素的 第二大 整数。
 * <p>
 * 如果 nums[j] 满足以下条件，那么我们称它为 nums[i] 的 第二大 整数：
 * <p>
 * j > i
 * nums[j] > nums[i]
 * 恰好存在 一个 k 满足 i < k < j 且 nums[k] > nums[i] 。
 * 如果不存在 nums[j] ，那么第二大整数为 -1 。
 * <p>
 * 比方说，数组 [1, 2, 4, 3] 中，1 的第二大整数是 4 ，2 的第二大整数是 3 ，3 和 4 的第二大整数是 -1 。
 * 请你返回一个整数数组 answer ，其中 answer[i]是 nums[i] 的第二大整数。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/12
 */
public class L2454 {
    public static void main(String[] args) {
        //[272,238,996,406,763,164,102,948,217,760,609,700,848,637,748,718,469,449,502,703,292,86,91,551,699,293,244,406,22,968,434,805,910,927,623,79,108,541,411]
        System.out.println(Arrays.toString(new L2454().secondGreaterElement(new int[]{2, 4, 0, 9, 6})));
    }

    /**
     * 双单调栈，从左往右遍历，当前元素比s栈顶元素大，s栈顶元素出栈，进t栈，当前元素入s栈，当前元素比t栈的大，则找到
     * 方式是使用两个len指针，控制s栈和t栈的长度，移动到t栈使用数组复制的方式
     * @param nums
     * @return
     */
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] s = new int[100000];
        int[] t = new int[100000];
        int[] ans = new int[n];
        int lent = 0;
        int lens = 0;
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            while (lent > 0 && nums[t[lent - 1]] < nums[i]) {
                ans[t[--lent]] = nums[i];
            }
            int tmp = lens;
            while (lens > 0 && nums[s[lens - 1]] < nums[i]) {
                lens--;
            }
            int i1 = tmp - lens;
            System.arraycopy(s, lens, t, lent, i1);
            lent += i1;
            s[lens++] = i;
        }
        return ans;
    }

}
