package com.fqh;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {



    //=====================================测试线程池的使用====================================
    //======================================================================================


    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int CAPACITY = 100;
    private static final long KEEP_ALIVE_TIME = 1L;


    static class Worker implements Runnable {

        private String command;

        public Worker(String command) {
            this.command = command;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start. Time: " + LocalDateTime.now().format(dtf));
            processCommand();
            System.out.println(Thread.currentThread().getName() + " End. Time: " + LocalDateTime.now().format(dtf));
        }

        private void processCommand() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Worker{" +
                    "command='" + command + '\'' +
                    '}';
        }
    }


    static void show() {
        var executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; i++) {
            int x = i;
            executor.execute(() -> new Worker("" + x));
        }
        executor.shutdown();
        while (!executor.isTerminated()) {}
        System.out.println("All Task Finished");
    }


    public static void main(String[] args) {
        show();
    }
}
