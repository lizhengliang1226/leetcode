package com.lzl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 回溯
 *
 * @author LZL
 * @version v1.0
 * @date 2022/7/27-9:30
 */
public class DFS {

    public List<List<Integer>> per(int[] nums) {
        // 获取最大深度
        int l = nums.length;
        // 结果集
        List<List<Integer>> res = new ArrayList<>();
        if (l == 0) {
            return res;
        }
        final boolean[] used = new boolean[l];
        Deque<Integer> path = new ArrayDeque<>();
        // 要遍历的数组，最大深度，起始深度一开始为0，结果集暂存数组，状态数组，结果集
        ddfs(nums, l, 0, path, used, res);
        return res;
    }

    private void ddfs(int[] nums, int l, int depth, Deque<Integer> path,
                      boolean[] used, List<List<Integer>> res) {
        if (depth == l) {
            // 直到已经遍历到最大深度了，将当前暂存数组结果放到真正的结果集中
            res.add(new ArrayList<>(path));
            return;
        }
        // 按最大深度来遍历
        for (int i = 0; i < l; i++) {
            if (!used[i]) {
                // 当前元素的状态为未使用，则将其添加到暂存结果数组
                path.addLast(nums[i]);
                used[i] = true;
                // 添加好后，将深度加一，然后继续重新遍历全部数组元素，看那个还没加的，继续加
                ddfs(nums, l, depth + 1, path, used, res);
                // 走到这里说明已经到最大深度了，那个暂存数组已经被添加到了结果集中，返回了，
                // 所以要把当前元素的状态设置为未使用
                used[i] = false;
                // 然后移除当前元素
                path.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        System.out.println(path);
        if (depth == len) {
            // 深度已到最深，把当前数组存入结果集
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 当前元素未使用过。加入结果
                path.addLast(nums[i]);
                // 设置状态为已使用
                used[i] = true;
                // 将深度加一，继续构造结果
                dfs(nums, len, depth + 1, path, used, res);
                // 返回时说明深度已到最大值，设置当前值为已使用
                used[i] = false;
                // 移除最后一个选择的元素
                path.removeLast();
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        DFS solution = new DFS();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }
}