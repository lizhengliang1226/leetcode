package com.lzl;


/**
 * 1457. 二叉树中的伪回文路径
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * <p>
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 * 首先考虑一个路径是否是伪回文的。如果一个序列和它倒过来的序列一样，那它就是一个回文序列。一个回文序列，如果长度为偶数，那么肯定满足序列中的每种元素出现的次数都是偶数次，因为序列中每个位置的元素都有一个相同的对称位置的元素。而如果长度为奇数，那么除了位置位于中间的元素在序列中出现的次数是奇数次，其他元素出现的次数都是偶数次。总结起来就是，回文序列最多只有一个元素在序列中出现的次数是奇数次，其他元素出现的次数都是偶数次。并且这是一个充要条件，一个集合，如果其中至多只有一个元素的次数是奇数次，那么这个集合可以组成一个排列是回文序列。这道题中，可以记录从根节点到叶子节点的路径的所有节点的集合，判断是否只有至多一个元素出现的次数是奇数来判断路径是否为伪回文。
 * <p>
 * 因为节点的值只可能为 111 到 999，因此可以用一个长度为 101010 的数组 counter\textit{counter}counter 来记录路径中各个值出现的次数。并且用深度优先搜索的方式来遍历所有叶子，定义函数 dfs\textit{dfs}dfs，输入为接下去要访问的节点，和记录了根节点到该节点（不含）的路径上各个值出现的次数的数组 counter\textit{counter}counter，并返回一个整数，用来表示根节点到以该节点为祖先的叶子节点的所有路径中伪回文路径的数目。函数中，首先判断该节点是否为空，如果为空，则返回 000。接下来更新 counter\textit{counter}counter，表示访问到了当前节点。然后判断当前节点是否为叶子节点，如果是，按照上一段的方法判断 counter\textit{counter}counter 中的所有元素是否能构成一个回文序列。如果不是叶子节点，则分别访问当前节点的两个子节点，将返回值求和作为自己的返回值。最后在返回之前，需要撤销一开始对 counter\textit{counter}counter 的更新。对根
 * <p>
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author LZL
 * @version 1.0
 * @since 2023/11/25
 */
public class L1457 {
    int pathNum = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        // 一个回文序列，最多只有一个元素出现的次数是奇数次，其他都是偶数次
        // 遍历，得到所有的组合
        // i是数字，值是每个数出现的次数
        // 把指定位变成0，1111011与运算
        // 把指定位变成1，00001000或运算
        // 指定位反转，异或运算 0000100  1111101111
        // 123456789
        //      987654321
        //mark= 000000000
        // 1010101
        // 1出现奇数次，0，出现偶数次
        // 8
        /**
         * 8
         8
         7  7
         */
        return dfs3(root, 0);
    }

    private int dfs3(TreeNode root, int mark) {
        if (root.left == root.right) {
            if((mark&(-mark))==mark){
                return 1;
            }
            return 0;
        }
        mark^=1<<root.val;
        return dfs3(root.left,mark)+dfs3(root.right,mark);

    }

    private void dfs1(TreeNode root, int mark) {
        if (root.left == null && root.right == null) {
            mark ^= 1 << root.val;
            if ((mark & (-mark)) == mark) {
                pathNum++;
            }
            return;
        }
        // 000000000
        if (root.left != null) {
            // 把对应的位翻转
            // mark=mark^(1<<root.val)
            dfs1(root.left, mark ^ (1 << root.val));
        }
        if (root.right != null) {
            // 把对应的位翻转
            dfs1(root.right, mark ^ (1 << root.val));
        }
    }
//    private int dfs2(TreeNode root, int mark) {
//        if(root==null){
//            if(isReverse1(mark)){
//                return 1;
//            }
//            return 0 ;
//        }
//        mark=mark^1<<(root.val-1);
//
//    }

    private boolean isReverse1(int num) {
        return (num & (-num)) == num;
        //12 1100
        //   1011
        //1奇数，0偶数 最多只能有一个1
//        int count=0;
//        while (num != 0) {
//            num = num & (num - 1);
//            count++;
//            if(count>1)break;
//        }
//        return count>1;
//        return false;
    }

    private void dfs(TreeNode root, int[] counter) {
        if (root.left == null && root.right == null) {
            if (isReverse(counter)) {
                pathNum++;
            }
            return;
        }
        if (root.left != null) {
            counter[root.left.val]++;
            dfs(root.left, counter);
            counter[root.left.val]--;
        }
        if (root.right != null) {
            counter[root.right.val]++;
            dfs(root.right, counter);
            counter[root.right.val]--;
        }
    }

    private boolean isReverse(int[] path) {
        int num = 0;
        for (int i = 0; i < path.length; i++) {
            if (path[i] % 2 != 0) {
                num++;
                if (num > 1) break;
            }
        }
        return num <= 1;
    }


}