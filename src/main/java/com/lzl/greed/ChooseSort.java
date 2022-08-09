package com.lzl.greed;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author LZL
 * @version v1.0
 * @date 2022/8/9-17:03
 */
@Slf4j
public class ChooseSort {
    public static void main(String[] args) {
        new ChooseSort().selectSort(new int[] {1, 89, 3, 4,44,-9});
    }
    public void selectSort(int[] a){
        log.info("排序前：{}", Arrays.toString(a));
        for (int i = 0; i < a.length; i++){
            int minI=i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[minI]) {
                    minI=j;
                }
            }
            swap(a,i,minI);
        }
        log.info("排序后：{}", Arrays.toString(a));

    }

    private void swap(int[] a, int i, int minI) {
        int t=a[i];
        a[i]=a[minI];
        a[minI]=t;
    }
}