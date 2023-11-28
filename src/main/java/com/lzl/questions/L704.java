package com.lzl.questions;

/**
 * 704. 二分查找
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/28
 */
public class L704 {
    public static void main(String[] args) {
        System.out.println(new L704().search(new int[]{1,2,3,4,5,6,7,8,9}, 9));
    }

    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<=right){
                mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
}
