package com.lzl.arrpoint;

/**
 * 344. 反转字符串
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/10
 */
public class L344 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 1) return;
        if (s.length == 2) {
            char c = s[0];
            s[0] = s[1];
            s[1] = c;
            return;
        }
        int left = 0, right = s.length - 1;
        while (left != right && left <= right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
