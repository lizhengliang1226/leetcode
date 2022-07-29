package com.lzl;

import com.lzl.util.LeetCodeUtil;
import com.lzl.util.ListNode;

import java.util.*;

/**
 * Hello world!
 *
 * @author 17314
 */

public class App {
    private ModuleClass app;

    /**
     * 35. 搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     */
    public int searchInsert(int[] nums, int target) {
        // 二分查找
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        if (target == nums[nums.length - 1]) return nums.length - 1;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        if (target > nums[l]) return l + 1;
        return l;
    }

    private void print(String... strs) {
        System.out.println("=====" + Arrays.toString(strs) + "=====");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        final App app = new App();
//        System.out.println(app.myAtoi("+-3"));
//    app.isPalindrome(1233321);
//        System.out.println(app.intToRoman(3356));
//        app.romanToInt("MMMCCCLVI");
//        System.out.println(app.longestCommonPrefix(new String[]{"abcdf", "abc", "ab"}));
//        app.threeSum(new int[]{2, 3, -5, 8, 9, -17, 3, 5, 6, 71, 2, 3, -4, -9, -2, -78});
//        System.out.println(app.threeSumClosest(new int[]{-3, -2, -5,3, -4}, -1));
//        System.out.println(app.letterCombinations("233"));
//        System.out.println(app.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//        System.out.println(app.isValid("()"));
//        System.out.println(app.generateParenthesis(6));
//        app.mergeKLists(new ListNode[]{LeetCodeUtil.getSortList(1), null, LeetCodeUtil.getSortList(1)});
//        final ListNode listNode = app.swapPairs(LeetCodeUtil.getSortList(7));
//        traverse(listNode);
//        final ListNode listNode = app. reverseKGroup(LeetCodeUtil.getSortList(2), 2);
//        traverse(listNode);
//        System.out.println(app.removeDuplicates(new int[]{1, 1, 2, 2, 3, 3}));
//        System.out.println(app.strStr("abababaaabaabababaabddd", "aabaabababaab"));
//        System.out.println(app.divide(16,-3));
//    app.nextPermutation(LeetCodeUtil.getIntAry(6,1,LeetCodeUtil.NO_SORT));
//        LeetCodeUtil.traverseAry(app.searchRange(new int[]{1}, 1));
        app.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    /**
     * 77. 组合
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * <p>
     * 你可以按 任何顺序 返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * 示例 2：
     * <p>
     * 输入：n = 1, k = 1
     * 输出：[[1]]
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        return null;
    }

    /**
     * 40. 组合总和 II
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * <p>
     * 注意：解集不能包含重复的组合。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Deque<Integer> path = new ArrayDeque<Integer>();
        int l = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        // 排序数组、暂存值数组、目标值、长度、结果集、开始位置
        // 这个开始位置是为了选取元素不重复，不能选取相同元素的时候要设置，也可以用used数组代替
        // ，在循环里面判断就好但会浪费空间
        dfs2(candidates, path, target, l, res, 0);
        return res;
    }

    private void dfs2(int[] candidates,
                      Deque<Integer> path,
                      int target,
                      int l,
                      List<List<Integer>> res,
                      int begin) {
        // 目标值为0说明已找到，保存值
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 从begin开始遍历，就是为了之前选取过的数就不要再去取了，如果从0开始又会选到之前选过的数
        for (int i = begin; i < l; i++) {
            // 如果当前数减去后已经小于0了，后面的数就更不可能得到结果了
            if (target - candidates[i] < 0) break;
            // 同一层后面的与前面相同，那一定使用过了会重复
            if (i > begin && candidates[i - 1] == candidates[i]) continue;
            // 上面两个都没结束，说明该数被减后大于0且还没被使用过且与前一个数不相同也就是不会重复
            path.addLast(candidates[i]);
            dfs2(candidates, path, target - candidates[i], l, res, i + 1);
            path.removeLast();
        }
    }

    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        int l = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack1(nums, l, used, path, res, 0);
        return null;
    }

    private void backtrack1(int[] nums, int l, boolean[] used, Deque<Integer> path, List<List<Integer>> res, int depth) {
        if (depth == l) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < l; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backtrack1(nums, l, used, path, res, depth + 1);
            used[i] = false;
            path.removeLast();
        }
    }

    /**
     * 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：[[1]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        Deque<Integer> path = new ArrayDeque();
        boolean[] used = new boolean[nums.length];
        int l = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs1(nums, l, 0, used, res, path);
        return res;
    }

    private void dfs1(int[] nums, int l, int depth, boolean[] used, List<List<Integer>> res, Deque<Integer> path) {
        if (depth == l) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < l; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs1(nums, l, depth + 1, used, res, path);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    /**
     * 39. 组合总和
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
     * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * <p>
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * <p>
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * 示例 2：
     * <p>
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     * <p>
     * 输入: candidates = [2], target = 1
     * 输出: []
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(target, candidates, res, path, 0);
        return res;
    }

    private void dfs(int target, int[] candidates, List<List<Integer>> res, List<Integer> path, int i) {
        // 已经到最后一个位置了，不能再忘下了，返回
        if (i == candidates.length) {
            return;
        }
        // 找到了目标集，返回
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 直接跳过,这里相当于用跳过来倒序遍历数组，然后往下走开始算满足条件的值
        print("1dfs压栈", "索引" + i);
        dfs(target, candidates, res, path, i + 1);
        print("1dfs出栈", "索引" + i);
        if (target - candidates[i] >= 0) {
            // 如果满足条件，则加入暂存数组
            path.add(candidates[i]);
            // 继续遍历，这时候他又会走一遍上面的那个dfs，
            // 然后一直把i加到数组的长度才会返回，然后又从数组末端找符合条件的
            print("2dfs压栈", "索引" + i);
            dfs(target - candidates[i], candidates, res, path, i);
            print("2dfs出栈", "索引" + i);

            // 走到这里后说明在当前树下找不到符合条件的，要回溯去找其他的，所以删除最后一个元素，然后返回
            // 由于返回的时候就走到上一个dfs处，所以那个变量i就自动减一了，也就完成了倒叙遍历
            path.remove(path.size() - 1);
        } //   /|
        //  ||
        print("dfs出栈");
        // 这个位置说明找不到符合条件的，然后就会返回，走到上面那行
    }


    /**
     * 38. 外观数列
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     * <p>
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     * <p>
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     * <p>
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     * 前五项如下：
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 第一项是数字 1
     * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
     * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
     * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
     * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
     * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。
     * 然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，
     * 先将每组中的字符数量用数字替换，再将所有描述组连接起来。
     * <p>
     * 例如，数字字符串 "3322251" 的描述如下图：
     * <p>
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 1
     * 输出："1"
     * 解释：这是一个基本样例。
     * 示例 2：
     * <p>
     * 输入：n = 4
     * 输出："1211"
     * 解释：
     * countAndSay(1) = "1"
     * countAndSay(2) = 读 "1" = 一 个 1 = "11"
     * countAndSay(3) = 读 "11" = 二 个 1 = "21"
     * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String str = "1";
        // 从第二项开始生成
        for (int i = 2; i <= n; i++) {
            // 用来存储生成的串
            StringBuilder sb = new StringBuilder();
            // 读取的字符位置
            int pos = 0;
            // 开始读取的位置
            int start = 0;
            // 还没读取完就一直读
            while (pos < str.length()) {
                // 还没读取完，当前字符与开始字符相同
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    // 出现的次数加一
                    pos++;
                }
                // 读到了不相同的字符，结束，求出那个开始字符出现的次数
                int times = pos - start;
                // 将此次字符出现的次数和字符添加进串
                sb.append(times).append(str.charAt(start));
                // 重置开始位置为当前读取的位置
                start = pos;
            }
            // 循环完全结束，字符重新生成完成，重新赋值
            str = sb.toString();
        }
        return str;
    }

    /**
     * 36. 有效的数独
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * <p>
     * <p>
     * 注意：
     * <p>
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 空白格用 '.' 表示。
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] sub = new int[3][3][9];
        // 以数字本身为hash
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    cols[j][index]++;
                    sub[i][j][index]++;
                    if (rows[i][index] > 1 || cols[j][index] > 1 || sub[i][j][index] > 1) return false;
                }
            }
        }
        return true;
    }

    private static void test4(App app) {
        final double medianSortedArrays = app.findMedianSortedArrays(LeetCodeUtil.getIntAry(0, 1), LeetCodeUtil.getIntAry(5, 1));
        System.out.println(medianSortedArrays);
    }

    /**
     * 4. 寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        LeetCodeUtil.traverse(nums1);
        LeetCodeUtil.traverse(nums2);
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        if (nums1 == null || nums1.length < 1) {
            return getMid(nums2);
        }
        if (nums2 == null || nums2.length < 1) {
            return getMid(nums1);
        }
        int i = 0, j = 0, t = 0;
        int[] temp = new int[nums1.length + nums2.length];
        while (i <= nums1.length - 1 && j <= nums2.length - 1) {
            if (nums1[i] <= nums2[j]) {
                temp[t++] = nums1[i++];
            } else {
                temp[t++] = nums2[j++];
            }
        }
        while (i <= nums1.length - 1) {
            temp[t++] = nums1[i++];
        }
        while (j <= nums2.length - 1) {
            temp[t++] = nums2[j++];
        }
        LeetCodeUtil.traverse(temp);
        int mid = (nums1.length + nums2.length) / 2;
        if ((nums1.length + nums2.length) % 2 == 0) {
            double a = temp[mid] + temp[mid - 1];
            return a / 2;
        } else {
            return temp[mid];
        }
    }

    private double getMid(int[] a) {
        if (a.length % 2 == 0) {
            return (double) (a[a.length / 2] + a[a.length / 2 - 1]) / 2;
        } else {
            return a[a.length / 2];
        }
    }

    /**
     * 8. 字符串转换整数 (atoi)
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     * <p>
     * 函数 myAtoi(string s) 的算法如下：
     * <p>
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
     * 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，
     * 则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，
     * 使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
     * 返回整数作为最终结果。
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '+' && s.charAt(0) != '-') {
            return 0;
        }
        long ans = 0L;
        boolean neg = s.charAt(0) == '-';
        int i = !Character.isDigit(s.charAt(0)) ? 1 : 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            ans = ans * 10 + (s.charAt(i++) - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        return neg ? (int) -ans : (int) ans;
    }

    /**
     * 9. 回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        if (x % 10 == 0) {
            return false;
        }
        int org = x;
        int res = 0;
        while (x > res) {
            int g = x % 10;
            x /= 10;
            res = res * 10 + g;
            System.out.println("g=" + g);
            System.out.println("x=" + x);
            System.out.println("res=" + res);
        }
        return x == res || x == res / 10;
    }

    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器。
     * 使用双指针
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int mr = 0;
        while (l < r) {
            int ar = Math.min(height[l], height[r]) * (r - l);
            if (ar > mr) {
                mr = ar;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return mr;
    }

    /**
     * 12. 整数转罗马数字
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，
     * 而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
     * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给你一个整数，将其转为罗马数字。
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
                i--;
            }
        }
        return sb.toString();
    }

    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，
     * 而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
     * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        final int len = s.length();
        int res = 0;
        int prevNum = getValue(s.charAt(0));
        for (int i = 1; i < len; i++) {
            int num = getValue(s.charAt(i));
            if (prevNum >= num) {
                res += prevNum;
            } else {
                res -= prevNum;
            }
            prevNum = num;
        }
        res += prevNum;
        System.out.println(res);
        return res;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c
     * ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList(16);
        //去除部分重复
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //一重循环，去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //定义target
            int a = -nums[i];
            //定义右指针
            int three = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                //二重循环，去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int b = nums[j];
                //左右指针不断移动直到找到或者相等退出循环
                while (j < three && b + nums[three] > a) three--;
                //如果是相等说明没找到，结束此次循环
                if (j == three) break;
                //否则找到了，添加进去
                if (b + nums[three] == a) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[three]);
                    list.add(list1);
                }
            }
        }
        return list;
    }

    /**
     * 16. 最接近的三数之和
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
     * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int best = 1000000000;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int t1 = nums[i];
            int r = nums.length - 1;
            int j = i + 1;
            while (j < r) {
                int sum = t1 + nums[j] + nums[r];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    while (j < r - 1 && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                } else {
                    while (j + 1 < r && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    j++;
                }
            }
        }
        return best;
    }

    /**
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例 1：
     * <p>
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null | digits.equals("")) return new ArrayList<>();
        List<List<String>> list = new ArrayList<>(16);
        for (int i = 0; i < digits.length(); i++) {
            int n = Integer.parseInt(String.valueOf(digits.charAt(i)));
            final List<String> strByNum = getStrByNum(n);
            list.add(strByNum);
        }
        List<String> cur = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            final List<String> chars = list.get(i);
            cur = getDika(cur, chars);
        }
        return cur;
    }

    private List<String> getDika(List<String> chars, List<String> chars1) {
        List<String> dk = new ArrayList<>(chars.size() * chars1.size());
        int index = 0;
        for (int i = 0; i < chars.size(); i++) {
            for (int i1 = 0; i1 < chars1.size(); i1++) {
                dk.add(index++, chars.get(i) + chars1.get(i1));
            }
        }
        return dk;
    }

    private List<String> getStrByNum(int num) {
        switch (num) {
            case 2:
                return Arrays.asList("a", "b", "c");
            case 3:
                return Arrays.asList("d", "e", "f");
            case 4:
                return Arrays.asList("g", "h", "i");
            case 5:
                return Arrays.asList("j", "k", "l");
            case 6:
                return Arrays.asList("m", "n", "o");
            case 7:
                return Arrays.asList("p", "q", "r", "s");
            case 8:
                return Arrays.asList("t", "u", "v");
            case 9:
                return Arrays.asList("w", "x", "y", "z");
            default:
                return null;
        }
    }

    /**
     * 18. 四数之和
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
     * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
     * <p>
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        List<List<Integer>> list = new ArrayList<>(16);
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int r = n - 1;
                int tsum = nums[i] + nums[j];
                for (int k = j + 1; k < n; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    while (k < r && tsum + nums[k] + nums[r] > target) {
                        r--;
                    }
                    if (k == r) {
                        break;
                    }
                    if (tsum + nums[k] + nums[r] == target) {
                        List<Integer> list1 = new ArrayList<>(4);
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[k]);
                        list1.add(nums[r]);
                        list.add(list1);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * 进阶：你能尝试使用一趟扫描实现吗？
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //两趟
//        ListNode h=head;
//        int count=0;
//        for(ListNode cur=head;cur!=null;cur=cur.next){
//            count++;
//        }
//        if(count-n==0){
//            return h.next;
//        }
//        int index=0;
//        for(ListNode cur=head;cur!=null;cur=cur.next){
//            if((index+1)==count-n){
//                cur.next=cur.next.next;
//            }
//            index++;
//        }
//        return h;

        //栈实现遍历一趟
        Stack<ListNode> storage = new Stack<>();

        for (ListNode cur = head; cur != null; cur = cur.next) {
            storage.push(cur);
        }
        int count = 0;
        while (count != n) {
            count++;
            storage.pop();
        }
        if (storage.empty() && head.next == null) {
            return null;
        }
        if (storage.empty()) {
            return head.next;
        }
        ListNode top = storage.peek();

        top.next = top.next.next;
        return head;
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "()"
     * 输出：true
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.equals("")) return true;
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                if (!stack.pop().equals(getL(c))) return false;
            }
        }
        return stack.empty();
    }


    private char getL(char c) {
        switch (c) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return 0;
        }
    }

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l1h = l1;
        ListNode l2h = l2;
        ListNode h = new ListNode();
        ListNode f = h;
        while (l1h != null && l2h != null) {
            if (l1h.val > l2h.val) {
                h.next = l2h;
                h = h.next;
                l2h = l2h.next;
            } else {
                h.next = l1h;
                h = h.next;
                l1h = l1h.next;
            }
        }
        if (l1h != null) {
            h.next = l1h;
        } else {
            h.next = l2h;
        }
        return f.next;
    }

    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 有效括号组合需满足：左括号必须以正确的顺序闭合。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(16);
        if (n == 0) {
            return result;
        }
        backtrack("", n, n, result);
        return result;
    }

    private void backtrack(String curStr, int ln, int rn, List<String> result) {
        if (ln == 0 && rn == 0) {
            result.add(curStr);
            return;
        }
        if (ln > rn) {
            return;
        }
        if (ln > 0) {
            backtrack(curStr + "(", ln - 1, rn, result);
        }
        if (rn > 0) {
            backtrack(curStr + ")", ln, rn - 1, result);
        }
    }

    /**
     * 23. 合并K个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        for (int i = 0; i < lists.length; i++) {
//            System.out.println(lists[i]);
            if (lists[i] != null) {
                head = mergeTwoLists(lists[i], head);
            }
        }
//        traverse(head);
        return head;
    }

    private static void traverse(ListNode node) {
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 24. 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;
        head.next = swapPairs(head.next);
        return newHead;
    }

    /**
     * 25. K 个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 进阶：
     * <p>
     * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k < 2) return head;
        ListNode prev, end, dump;
        dump = new ListNode();
        dump.next = head;
        prev = end = dump;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            prev.next = getReverseListNode(start);
            start.next = next;
            prev = start;
            end = prev;
        }
        return dump.next;
//        if(head==null||head.next==null)return head;
//        if(k<2)return head;
//        ListNode rh=head;
//        Stack<ListNode> stack=new Stack();
//        ListNode newH=new ListNode();
//        ListNode h=newH;
//        int len=0;
//        ListNode lhead=head;
//        while(lhead!=null){
//            len++;
//            lhead=lhead.next;
//        }
//        int count=0;
//        if(len==k){
//            return getReverseListNode(head);
//        }
//        if(len%k==0){
//            do {
//                while(count != k) {
//                    stack.push(head);
//                    head = head.next;
//                    count++;
//                }
//                count = 0;
//                for(int i = 0; i < k; i++) {
//                    ListNode ele = stack.pop();
//                    ele.next = null;
//                    newH.next = ele;
//                    newH = ele;
//                }
//            } while(head != null);
//        }else{
//            do {
//                while(count != k && head != null) {
//                    stack.push(head);
//                    head = head.next;
//                    count++;
//                }
//                if(head==null)break;
//                count = 0;
//                for(int i = 0; i < k; i++) {
//                    ListNode ele = stack.pop();
//                    ele.next = null;
//                    newH.next = ele;
//                    newH = ele;
//                }
//            } while(head != null);
//            if(!stack.empty()){
//                ListNode last=null;
//                while(!stack.empty()){
//                    last = stack.pop();
//                }
//                newH.next = last;
//            }
//        }
//
//        return h.next;
    }

    /**
     * 倒转链表
     *
     * @param head 链表头节点
     * @return 倒转后的头节点
     */
    private ListNode getReverseListNode(ListNode head) {
        ListNode dump = new ListNode();
        dump.next = head;
        ListNode cur = head.next;
        while (cur != null) {
            head.next = cur.next;
            cur.next = dump.next;
            dump.next = cur;
            cur = head.next;
        }
        return dump.next;
//        Stack<ListNode> s=new Stack();
//        ListNode l=new ListNode();
//        ListNode head=l;
//        for(ListNode h=head;h!=null;h=h.next){
//            s.push(h);
//        }
//        while(!s.empty()){
//            ListNode pop = s.pop();
//            pop.next=null;
//            l.next=pop;
//            l=pop;
//        }
//        return head.next;
    }

    /**
     * 26. 删除有序数组中的重复项
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums 数组
     * @return 移除重复元素后数组的大小
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int slow = 1;
        //快慢指针，快指针遍历1-n，当相邻元素不相同则赋值i到slow的位置，slow+1，最后返回slow;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[slow++] = nums[i];
            }
        }
        return slow;
    }

    /**
     * 27. 移除元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，
     * 并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums 数组
     * @param val  要移除的元素
     * @return 移除后数组的大小
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int fast = 0;
        int slow = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    /**
     * 28. 实现 strStr()
     * 实现 strStr() 函数。
     * <p>
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle
     * 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
     * 遍历字串求next
     * 遍历主串求结果
     *
     * @param haystack 模式串
     * @param needle   匹配串
     * @return 在模式串中第一次出现的位置
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 && needle == null || needle.length() == 0) {
            return 0;
        }
        final int hl = haystack.length();
        final int nl = needle.length();
        int[] next = getNext(needle);
        for (int i = 0, j = 0; i < hl; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == nl) {
                return i - nl + 1;
            }
        }
        return -1;
    }

    /**
     * 获取next数组
     *
     * @param needle 匹配串
     * @return next数组
     */
    private int[] getNext(String needle) {
        int len = needle.length();
        int[] next = new int[len];
        int i = 1;
        int j = 0;
        for (; i < len; i++) {
            //只有j大于0才会跳转，当j一直不大于0时，就一直判断i和j的位置是否适配，
            // 如果不适配，就一直让i++（后缀，相当于前缀不动，
            // 一直往后移找到第一个匹配的前缀为止，此时j才会加一大于0，
            // 然后在失配时又根据生成的next
            // 数组跳转到指定索引）
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                //当j大于0时无限循环，直到找到一个j匹配当前的i，或者j被指定到最初始的0才会结束循环
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                //一旦匹配，前缀加一
                j++;

            }
            //设置当前元素的跳转位置
            next[i] = j;
        }
        return next;
    }

    /**
     * 29. 两数相除
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * <p>
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * <p>
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        boolean sign = divisor > 0 ^ dividend > 0;
        long div = Math.abs((long) dividend);
        long dir = Math.abs((long) divisor);
        long res = 0;
        long digit = 0;
        //计算除数要乘几个2才能大于被除数,16/3为例
        /*
        * digit: 3
        digit:==>2
        div:>==4
        res==>4
        digit:==>1
        digit:==>0
        div:>==1
        res==>5
        digit:==>-1
        -5
        * */
        while (div >= dir << digit) digit++;
        System.out.println("digit: " + digit);  //16>3*2*2*2  digit=3
        //之后开始计算
        while (div >= dir) {
            //每当被除数大于除数左移的位数，也就是乘的2的个数
            if (div >= dir << digit) {
                //第一次是digit=2
                //16-3*2*2=4
                //4-3*2^0=1
                //就把这个数剪掉然后重新赋值
                div -= dir << digit;
                System.out.println("div:>==" + div);
                //给结果集加一左移digit位
                res += (long) 1 << digit;//1*2*2,1*2^0
                System.out.println("res==>" + res);
            }
            digit--;
            System.out.println("digit:==>" + digit);
        }
        res = sign ? -res : res;
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) res;
    }

    /**
     * 31. 下一个排列
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（
     * 即，组合出下一个更大的整数）。
     * <p>
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * <p>
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * @param nums 数组
     */
    public void nextPermutation(int[] nums) {
//        LeetCodeUtil.traverseAry(nums);
        int flag = 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            //找到较小的数
            if (nums[i] > nums[i - 1]) {
                flag = 0;
                for (int j = nums.length - 1; j >= i; j--) {
                    //找到较大的数
                    if (nums[j] > nums[i - 1]) {
                        //交换
                        int t = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = t;
                        //倒转i后面的元素
                        reverse(nums, i);
                        break;
                    }
                }
                break;
            }
        }
        if (flag == 1) {
            reverse(nums, 0);
        }
//        LeetCodeUtil.traverseAry(nums);
    }

    private void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int t = nums[left];
        nums[left] = nums[right];
        nums[right] = t;
    }

    /**
     * 33. 搜索旋转排序数组
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
     * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）
     * 。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * <p>
     * 使用二分法，保证某一部分总是有序，然后根据大小改变mid1的值
     *
     * @param nums   数组
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //比最小值还要大，说明l-mid-1是有序的
            if (nums[mid] >= nums[0]) {
                if (target < nums[mid] && target >= nums[0]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {//说明mid+1,r有序
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * @param nums   数组
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        last = binarySearch(nums, target, true);
        first = binarySearch(nums, target, false) + 1;
        if (first <= last && last < nums.length && nums[first] == target && nums[last] == target) {
            return new int[]{first, last};
        }
        return new int[]{-1, -1};

    }

    /**
     * 二分查找，查找最后一个相等的元素或者第一个相等的元素的前一个元素
     *
     * @param nums   数组
     * @param target
     * @param lower
     * @return
     */
    private int binarySearch(int[] nums, int target, boolean lower) {
        int mid;
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target > nums[mid] || (lower && target >= nums[mid])) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}


class Stack<T> {
    private final LinkedList<T> storage = new LinkedList<T>();

    public void push(T v) {
        storage.addFirst(v);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }
}