package com.fqh;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {

    //================================测试原子整型类===================================
    // AtomicInteger.class
    //===========================================================================


    static void show() {
        int v = 0;
        var i = new AtomicInteger(0);
        v = i.getAndSet(3); // 获取后 并设置值
        System.out.println("v: " + v + " i: " + i);
        v = i.getAndIncrement();    // 获取后 自增
        System.out.println("v: " + v + " i: " + i);
        v = i.getAndAdd(5); // 获取后 加上delta值
        System.out.println("v: " + v + " i: " + i);
    }

    // 线程安全的计数器类 使用AtomicInteger实现
    static class Counter {

        private final AtomicInteger ai = new AtomicInteger(0);

        public Counter() {}

        public Counter(int initValue) {
            ai.compareAndSet(0, initValue);
        }

        public void incr() {
            ai.getAndIncrement();
        }

        public int getCount() {
            return ai.get();
        }
    }

    public static void main(String[] args) {
//        show();
        var ct = new Counter(9);
        ct.incr();
        System.out.println(ct.getCount());
    }
}
