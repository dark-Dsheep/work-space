package com.fqh;

import java.util.PriorityQueue;

public class TestHeap {

    //===========================测试堆=========================
    // PriorityQueue.class
    //=========================================================

    static void solve() {
        // 测试小顶堆
        // 给你一个数组, 每次消耗数组最小的两个元素, 将它们求和并作为数组新的元素
        // 求数组剩下的最后一个元素的值
        int[] arr = {3, 6, 2, 4, 9, 11, 2};
        var pq = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int x : arr) pq.offer(x);
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            pq.offer(x + y);
        }
        System.out.println("the last element: " + pq.peek());
    }

    public static void main(String[] args) {
        solve();
    }
}
