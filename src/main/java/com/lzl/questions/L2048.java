package com.lzl.questions;

/**
 * 2048. 下一个更大的数值平衡数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。
 * <p>
 * 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/09
 */
public class L2048 {
    public static void main(String[] args) {
        System.out.println(new L2048().nextBeautifulNumber(100));
    }

    public int nextBeautifulNumber(int n) {
        int ans = 0;
        boolean flag = false;
        // 1000000
        // 遇到一个数字，如果他大于当前字符串的长度，则直接下一个
        // 遇到数字0则直接结束
        // 遇到一个数字，从arr取出他之前出现的次数，如果加一已经大于了他本身，则结束
        for (int i = n + 1; !flag; i++) {
            if (isBlance(i)) {
                ans = i;
                flag = true;
            }
        }
        return ans;
    }

    private boolean isBlance(int num) {
        String s = String.valueOf(num);
        if (s.contains("0")) return false;
        int n = s.length();
        int[] arr = new int[10];
        for (int i = 0; i < n; i++) {
            int i1 = s.charAt(i) - '0';
            arr[i1]++;
            if (arr[i1] > i1)
                return false;
            if (i1 > n) return false;
        }
        for (int i1 = 1; i1 < arr.length; i1++) {
            // 此数出现在当前数的次数
            int count = arr[i1];
            if (count == 0) continue;
            if (count != i1) {
                return false;
            }
        }
        return false;
    }
    public int nextBeautifulNumber3(int n) {
        int [] res = new int[]{1,22,122,212,221,333,1333,3133,3313,3331,4444,
                14444,22333,23233,23323,23332,32233,32323,32332,33223,33232,33322,41444,44144,44414,44441,55555,
                122333,123233,123323,123332,132233,132323,132332,133223,133232,133322,155555,
                212333,213233,213323,213332,221333,223133,223313,223331, 224444,
                231233,231323,231332,232133,232313,232331,233123,233132,233213,233231,233312,233321,
                242444,244244,244424,244442,
                312233,312323,312332,313223,313232,313322,321233,321323,321332,
                322133,322313,322331,
                323123,323132,323213,323231,323312,323321,
                331223,331232,331322,332123,332132,332213,332231,332312,332321,
                333122,333212,333221,
                422444,424244,424424,424442,442244,442424,442442,444224,444242,444422,
                515555,551555,555155,555515,555551,666666
        };
        for (int re : res) {
            if(n < re) return re;
        }
        return 1224444;
    }
    public int nextBeautifulNumber2(int n) {
        for (int i = n + 1; i <= 1224444; ++i) {
            if (isBalance2(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBalance2(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        for (int d = 0; d < 10; ++d) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最简单的办法，效率也很低
     *
     * @param n
     * @return
     */
    public int nextBeautifulNumber1(int n) {
        int ans = 0;
        boolean flag = false;
        for (int i = n + 1; !flag; i++) {
            if (isBlance1(i)) {
                ans = i;
                flag = true;
            }
        }
        return ans;
    }

    private boolean isBlance1(int i) {
        String s = String.valueOf(i);
        int[] arr = new int[10];
        for (int j = 0; j < s.length(); j++) {
            int i1 = s.charAt(j) - '0';
            if (i1 == 0) return false;
            arr[i1]++;
        }

        for (int i1 = 1; i1 < arr.length; i1++) {
            // 此数出现在当前数的次数
            int count = arr[i1];
            if (count == 0) continue;
            if (count != i1) {
                return false;
            }
        }
        return true;
    }
}
