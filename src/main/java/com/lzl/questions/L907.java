package com.lzl.questions;

import com.lzl.util.Stack;

/**
 * 907. 子数组的最小值之和
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 */
public class L907 {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        // 以当前元素为最右最小元素的左区间，每个元素的子序列个数
        int[] left=new int[n];
        // 以当前元素为最左最小元素的右区间，每个元素的子序列个数
        int[] right=new int[n];
        Stack<Integer> monoStack=new Stack<>();
        for (int i = 0; i < n; i++) {
            while(!monoStack.isEmpty()&&arr[monoStack.peek()]>=arr[i]){
                monoStack.pop();
            }
            left[i]=i-(monoStack.isEmpty()?-1:monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();
        for (int i = n-1; i >=0 ; i--) {
            while(!monoStack.isEmpty()&&arr[monoStack.peek()]>arr[i]){
                monoStack.pop();
            }
            right[i]=i-(monoStack.isEmpty()?-1:monoStack.peek());
            monoStack.push(i);
        }
        long res=0;
        for (int i = 0; i < n; i++) {
            res+=arr[i]+left[i]+right[i];
        }
        long MOD=1000000007;
        return (int)(res%MOD);
    }
}