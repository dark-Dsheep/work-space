package com.fqh;

public class TestThreadState {


    //=====================测试java线程状态======================
    // NEW  初始
    // RUNNABLE 可运行
    // TIMED_WAITING 超时等待
    // WAITING 等待
    // BLOCKED 阻塞
    // TERMINATED 终止
    //=========================================================


    static void NEW() {
        var t = new Thread(() -> System.out.println("abc"), "T1");
        System.out.println(t.getName() + " state: " + t.getState());
    }

    static void RUNNABLE() {
        var t = new Thread(() -> System.out.println("abc"), "T1");
        t.start();
        System.out.println(t.getName() + " state: " + t.getState());
    }

    static void TIMED_WAITING() throws InterruptedException {
        var t = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("abc");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "T1");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.getName() + " state: " + t.getState());
    }

    static void BLOCKED() throws InterruptedException {
        var t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (a) {
                System.out.println("abc");
            }
        }, "T1");
        var t2 = new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "T2");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println(t1.getName() + " state: " + t1.getState());
    }

    static void WAITING() throws InterruptedException {
        var t1 = new Thread(() -> {
            synchronized (a) {
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("abc");
            }
        }, "T1");
        var t2 = new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                a.notifyAll();
            }
        }, "T2");
        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println(t1.getName() + " state: " + t1.getState());
    }

    static void TERMINATED() throws InterruptedException {
        var t = new Thread(() -> System.out.println("abc"), "T1");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.getName() + " state: " + t.getState());
    }

    static Object a = new Object();

    public static void main(String[] args) throws InterruptedException {
//        NEW();
//        RUNNABLE();
//        TIMED_WAITING();
//        BLOCKED();
//        WAITING();
        TERMINATED();
    }
}
