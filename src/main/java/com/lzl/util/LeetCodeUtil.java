package com.lzl.util;

import cn.hutool.core.util.RandomUtil;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description
 * @Author LZL
 * @Date 2021.08.30-13:42
 */
public class LeetCodeUtil {
    public static final int ASC = 1;
    public static final int DESC = -1;
    public static final int NO_SORT = 0;

    /**
     * 默认升序的一位数组
     *
     * @param aryLen
     * @return
     */
    public static int[] getIntAry(int aryLen) {
        return getIntAry(aryLen, 1, LeetCodeUtil.ASC);
    }

    public static int[] getIntAry(int aryLen, int eleLen) {
        int[] a = new int[aryLen];
        for(int i = 0; i < aryLen; i++) {
            a[i] = RandomUtil.randomInt((int) Math.pow(10.0, eleLen));
        }
        return a;
    }


    /**
     * @param aryLen 数组长度
     * @param sort   是否排序
     * @param eleLen 元素长度
     * @return
     */
    public static int[] getIntAry(int aryLen, int eleLen, int sort) {
        int[] ary = getIntAry(aryLen, eleLen);
        switch (sort) {
            case LeetCodeUtil.ASC:
                Arrays.sort(ary);
                break;
            case LeetCodeUtil.DESC:
                Arrays.sort(ary);
                reverse(ary, 0);
                break;
            default:
                break;
        }
        return ary;
    }

    private static void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    public static void traverse(int[] a) {
        if (a == null) {
            System.out.println("null");
            return;
        }
        for(int i = 0; i < a.length; i++) {
            if (i == 0) {
                System.out.print("[" + a[i] + ", ");
                continue;
            }
            if (i == a.length - 1) {
                System.out.println(a[i] + "]");
                continue;
            }
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }

    public static void traverseAry(int[] ary) {
        for(int i = 0; i < ary.length; i++) {
            if (i == ary.length - 1) {
                System.out.print(ary[i] + "]");
                continue;
            }
            if (i == 0) {
                System.out.print("[" + ary[i] + ", ");
                continue;
            }
            System.out.print(ary[i] + ", ");
        }
        System.out.println();
    }

    /**
     * 归并排序
     *
     * @param ary
     */
    public static void mergeSort(int[] ary) {
        int[] temp = new int[ary.length];
        sort(ary, 0, ary.length - 1, temp);
    }

    private static void sort(int[] ary, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(ary, left, mid, temp);
            sort(ary, mid + 1, right, temp);
            merge(ary, left, mid, right, temp);
        }
    }

    public static void merge(int[] ary, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(i <= mid && j <= right) {
            if (ary[i] <= ary[j]) {
                temp[t++] = ary[i++];
            } else {
                temp[t++] = ary[j++];
            }
        }
        while(i <= mid) {
            temp[t++] = ary[i++];
        }
        while(j <= right) {
            temp[t++] = ary[j++];
        }
        t = 0;
        while(left <= right) {
            ary[left++] = temp[t++];
        }
    }

    public static String getRandomStr(int len) {
        final int limit = RandomUtil.randomInt(len);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            if (len % 2 == 0) {
                if (i < limit) {
                    sb.append(RandomUtil.BASE_CHAR.charAt(RandomUtil.randomInt(26)));
                } else {
                    sb.append(RandomUtil.BASE_NUMBER.charAt(RandomUtil.randomInt(10)));
                }
            } else {
                if (i > limit) {
                    sb.append(RandomUtil.BASE_CHAR.charAt(RandomUtil.randomInt(26)));
                } else {
                    sb.append(RandomUtil.BASE_NUMBER.charAt(RandomUtil.randomInt(10)));
                }
            }
        }

        return sb.toString();
    }

    public static ListNode getSortList(int n) {
        ListNode cur = new ListNode();
        ListNode h = cur;
        for(int i = 0; i < n; i++) {
            cur.val = i;
            if (i == n - 1) {
                break;
            }
            cur.next = new ListNode();
            cur = cur.next;
        }
        return h;
    }
}


