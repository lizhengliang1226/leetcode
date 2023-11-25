package com.lzl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LZL
 * @version 1.0
 * @since 2023/11/18
 */
public class NQueen {
    public static void main(String[] args) {

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                path.add(".");
            }
            res.add(new ArrayList<>(path));
        }
        backtrack(res, path, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, List<String> path, int row) {
        if (row == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        int n=res.get(row).size();
        for (int col = 0; col < n; col++) {
            if(!isValid(res,row,col))continue;
            res.get(row).set(col,"Q");
            backtrack(res,path,row+1);
        }


    }

    private boolean isValid(List<List<String>> res, int row, int col) {
        return false;
    }
}
