package com.lzl;

/**
 * 左左小大：从左往右遍历，找到左边第一个比自己小的元素，符号 栈元素>当前元素 递减
 * 左左大小：从左往右遍历，找到左边第一个比自己大的元素，符号 栈元素<当前元素 递增
 * 右右小大：从右往左遍历，找到右边第一个比自己小的元素，符号 栈元素>当前元素 递减
 * 右右大小：从右往左遍历，找到右边第一个比自己大的元素，符号 栈元素<当前元素 递增
 */
public class MonoStack {
    public static void main(String[] args) {
        int[] a=new int[]{3,4,2,1};
        int n = a.length;
        Stack<Integer> monoStack=new Stack<>();
        //从左往右遍历， 单调递增栈，找到左边第一个比当前元素大的元素
        for (int i = 0; i < n; i++) {
            while(!monoStack.isEmpty()&&a[monoStack.peek()]<a[i]){
                monoStack.pop();
            }
            // 左边第一个比当前元素大的数
            System.out.println("此时元素是："+a[i]+"栈顶是："+(monoStack.isEmpty()?-1:a[monoStack.peek()]));
            monoStack.push(i);
        }
        System.out.println(monoStack);
        monoStack.clear();
        //从左往右， 单调递减栈，找到左边第一个比自己小的元素
        for (int i = 0; i < n; i++) {
            while(!monoStack.isEmpty()&&a[monoStack.peek()]>a[i]){
                Integer pop = monoStack.pop();
                // 弹出元素的右边第一个比自己小的元素是当前元素，得到右边界
                System.out.println("弹出："+a[pop]+"此时元素："+a[i]);
            }
            // 左边第一个比自己小的元素
            System.out.println("此时元素是："+a[i]+"栈顶是："+(monoStack.isEmpty()?-1:a[monoStack.peek()]));
            monoStack.push(i);
        }
        System.out.println(monoStack);
        monoStack.clear();
        //从右往左遍历， 单调递减栈，找到右边第一个比自己小的元素
        for (int i =n-1 ; i >=0 ; i--) {
            while(!monoStack.isEmpty()&&a[monoStack.peek()]>a[i]){
                monoStack.pop();
            }
            // 右边第一个比自己小的元素
            System.out.println("此时元素是："+a[i]+"栈顶是："+(monoStack.isEmpty()?-1:a[monoStack.peek()]));
            monoStack.push(i);
        }
        System.out.println(monoStack);
        monoStack.clear();
        //从右往左遍历， 单调递增栈，找到右边第一个比自己大的元素
        for (int i =n-1 ; i >=0 ; i--) {
            while(!monoStack.isEmpty()&&a[monoStack.peek()]<a[i]){
                monoStack.pop();
            }
            // 右边第一个比自己大的元素
            System.out.println("此时元素是："+a[i]+"栈顶是："+(monoStack.isEmpty()?-1:a[monoStack.peek()]));
            monoStack.push(i);
        }
        System.out.println(monoStack);
    }
}
