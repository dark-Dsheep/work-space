package com.fqh;

public class TestDeadLock {


    //=====================测试死锁==================================
    //
    //==============================================================

    static Object a = new Object(); // 资源a
    static Object b = new Object(); // 资源b

    static void show() {
        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() +  " get a");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting get b...");
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + " get b");
                }
            }
        }, "T1").start();

        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() +  " get b");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting get a...");
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + " get a");
                }
            }
        }, "T2").start();
    }

    public static void main(String[] args) {
        show();
    }
}
