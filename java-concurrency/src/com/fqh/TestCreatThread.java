package com.fqh;

import java.util.concurrent.*;

public class TestCreatThread {


    //====================创建线程的几种方式==========================
    // 1.new Thread(() -> {}) 调用start()方法
    // 2.实现Runnable接口
    // 3.实现Callable接口
    // 4.实现线程池
    //=============================================================

    static void createThreadByNew() {
        var t = new Thread(() -> System.out.println(Thread.currentThread().getName() + " exec..."), "T1");
        t.start();
    }

    static void createTheadByImplRunnable() {
        var w = new Worker();
        var t = new Thread(w, "workerThread");
        t.start();
    }

    static void createTheadByImplCallable() {
        var task = new CFer();
        var f = new FutureTask<String>(task);
        var t = new Thread(f, "CFerThread");
        t.start();
        try {
            System.out.println(f.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    static void createThreadByThreadPool() {
        var tp = Executors.newCachedThreadPool();
        tp.execute(() -> System.out.println("123"));
        tp.submit(() -> System.out.println("abc"));
        Future<String> future = tp.submit(new CFer());
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        tp.shutdown();
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " exec...");
        }
    }

    static class CFer implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "I'm CFer";
        }
    }

    public static void main(String[] args) {
//        createThreadByNew();
//        createTheadByImplRunnable();
//        createTheadByImplCallable();
        createThreadByThreadPool();
    }
}
