package com.lzl.datastruct;

/**
 * 数据结构-堆
 * <p>
 * 当前节点的编号x，
 * 左节点x*2，x<<1，
 * 右节点x*2+1，X<<1|1，
 * 父节点x/2，x>>1
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/29
 */
public class BigHeap {
    private int[] heap;

    public static void main(String[] args) {

    }

    public void add(int num){

    }
    /**
     * 向上调整
     */
    private void shiftUp(int x) {
        // 一直找父节点，如果比父节点大就与父节点交换，知道不大或者到根节点
       int parent= x>>1;
        while (heap[parent]<heap[x]&&x!=0) {
            swap(parent,x);
            x=parent;
            parent=x>>1;
        }
    }

    private void swap(int parent, int x) {
        int temp=heap[parent];
        heap[parent]=heap[x];
        heap[x]=temp;
    }

    /**
     * 向下调整
     */
    private void shiftDown(int x){
        // 一直找最大的子节点和他交换
        while(x<heap.length){
            int left=x<<1;
            int right=x<<1|1;
            if(heap[left]>heap[right]){
                swap(left,x);
                x=left;
            }else{
                swap(right,x);
                x=right;
            }
        }
    }

}