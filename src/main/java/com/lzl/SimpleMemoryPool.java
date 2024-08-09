package com.lzl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 简易内存池
 * 5
 * REQUEST=10
 * REQUEST=15
 * RELEASE=0
 * REQUEST=5
 * RELEASE=10
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/05
 */
public class SimpleMemoryPool {
    private int[] memory = new int[100];
    private Map<Integer, Integer> usedMemory = new HashMap<>();

    public static void main(String[] args) {
        SimpleMemoryPool pool = new SimpleMemoryPool();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String c = sc.nextLine();
            String[] con = c.split("=");
            if (con[0].equals("REQUEST")) {
                int size = Integer.parseInt(con[1]);
                System.out.println(pool.allocate(size));
            } else if (con[0].equals("RELEASE")) {
                String release = pool.release(Integer.valueOf(con[1]));
                if (release.equals("error")) {
                    System.out.println(release);
                }
            }
        }
    }

    public String allocate(int size) {
        int startAddr = findAvailableMemory(size);
        if (startAddr == -1) {
            return "error";
        }
        usedMemory.put(startAddr, size);
        Arrays.fill(memory, startAddr, startAddr + size, 1);
        return startAddr + "";
    }

    private int findAvailableMemory(int size) {
        if (size <= 0 || size > 100) {
            return -1;  // 错误大小的检查
        }

        int contiguousFreeSize = 0; // 当前连续空闲内存块的大小
        int startAddr = 0; // 当前检查的内存起始地址

        // 遍历内存池
        for (int i = 0; i < 100; i++) {
            if (memory[i] == 0) {
                contiguousFreeSize++;
                if (contiguousFreeSize == size) {
                    return i - size + 1; // 返回找到的内存块的起始地址
                }
            } else {
                contiguousFreeSize = 0; // 遇到分配内存块时重置计数
            }
        }

        return -1; // 如果遍历完成没有找到合适的块，则返回 -1
    }

    public String release(Integer memoryId) {
        if (usedMemory.containsKey(memoryId)) {
            Integer size = usedMemory.remove(memoryId);
            Arrays.fill(memory, memoryId, memoryId + size, 0);
            return "";
        }
        return "error";
    }
}