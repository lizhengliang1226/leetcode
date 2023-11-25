package com.lzl.backtrack;

import java.util.*;

/**
 * @author LZL
 * @version v1.0
 * @date 2023/8/5-17:33
 */
public class L39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> path=new ArrayDeque<>();
        List<List<Integer>> res=new ArrayList<>();
        int l=candidates.length;
        Arrays.sort(candidates);
        dfs(target,res,path,l,0,candidates);
        return res;
    }

    private void dfs(int target, List<List<Integer>> res, Deque<Integer> path, int l, int i, int[] candidates) {
        if(target==0){
            res.add(new ArrayList<>(path));
            return ;
        }
        if(target<0)return ;
        for (int j = i; j < l; j++) {
            path.addLast(candidates[j]);
            dfs(target-candidates[j],res,path,l,j,candidates);
            path.removeLast();
        }
    }
}
