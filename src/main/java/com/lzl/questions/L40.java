package com.lzl.questions;

import javax.swing.text.html.parser.TagElement;
import java.util.*;

/**
 * @author LZL
 * @version v1.0
 * @date 2023/8/5-17:54
 */
public class L40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int l = candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(0,l,res,path,candidates,target);
        return res;
    }

    private void dfs(int bg, int l, List<List<Integer>> res, Deque<Integer> path, int[] candidates, int target) {
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //1 1 2 5 6 7 10
        if(target<0)return;
        for (int i = bg; i < l; i++) {
            if(i>bg&&candidates[i]==candidates[i-1])continue;
            path.addLast(candidates[i]);
            dfs(bg+1,l,res,path,candidates,target-candidates[i]);
            path.removeLast();
        }

    }
}