package com.fqh;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestCompletableFuture {

    //===============================测试CompletableFuture类==========================
    // CompletableFuture.class 异步编程类
    //===============================================================================

    /**
     * 异步计算结果
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void AsyncCompute() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.completedFuture("f**k!")
                .thenApply(s -> s + "boy!")
                .thenApply(s -> s + "bro");
        System.out.println(future.get());
    }

    /**
     * whenComplete处理返回结果
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void WhenComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello!")
                .whenComplete((res, ex) -> {
                    // res是返回结果
                    // ex是抛出的异常
                    System.out.println(res);
                });
        System.out.println(future.get());
    }

    /**
     * handle异常处理机制
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void HandleException() throws ExecutionException, InterruptedException {
        var ok = false;
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (ok) {
                throw new RuntimeException("exec error!");
            }
            return "successful";
        }).handle((res, ex) -> res != null ? res : "ok");
        System.out.println(future.get());
    }

    /**
     * thenCompose组合两个任务
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void ComposeFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "abc")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "123"));
        System.out.println(future.get());
        // thenCombine也是类似
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "123")
                .thenCombine(CompletableFuture.supplyAsync(() -> "abc"), (f1, f2) -> f1 + f2)
                .thenCompose(f -> CompletableFuture.supplyAsync(() -> f + "xyz"));
        System.out.println(future1.get());
        // thenCompose会将前一个任务的返回结果作为下一个任务参数,它们之间存在先后顺序
        // thenCombine会在两个任务执行完成后,把两个任务的结果进行合并,两个任务是并行执行的
    }

    /**
     * allOf可以等待所有CompletableFuture任务执行完毕
     * anyOf可以返回任何一个任务执行完毕的结果
     */
    static void AllOf() {
        var f1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("f1 done...");
            }
            return "abc";
        });
        var f2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("f2 done...");
            }
            return "123";
        });
        var f3 =  CompletableFuture.allOf(f1, f2);
        f3.join();
        System.out.println("all future done...");
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        AsyncCompute();
//        WhenComplete();
//        HandleException();
//        ComposeFuture();
        AllOf();
    }
}
