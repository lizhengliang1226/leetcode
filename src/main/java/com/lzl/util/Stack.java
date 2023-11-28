package com.lzl.util;

import java.util.LinkedList;

/**
 * @author LZL
 * @version v1.0
 * @date 2022/8/6-20:20
 */
public class Stack<T> {
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
    public void clear() {
        storage.clear();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }
}