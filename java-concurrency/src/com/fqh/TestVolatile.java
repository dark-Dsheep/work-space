package com.fqh;

public class TestVolatile {

    //=========================测试volatile关键字保证变量的可见性========================
    // static volatile boolean ok = true;
    //===============================================================================


//    static boolean ok = true;
    static volatile boolean ok = true;

    /**
     * 不使用volatile修饰ok
     * B线程修改ok=false后, A线程会继续运行
     * A线程读取的ok是A线程的本地内存的共享变量副本
     * B线程操作的ok也是B线程得本地内存的共享变量副本
     */
    static void case1() throws InterruptedException {
        var a = new Thread(() -> {
            while (ok) {
                //...
            }
        }, "A");
        var b = new Thread(() -> {
            if (ok) {
                ok = false;
            }
            System.out.println("B线程将ok修改为: " + ok);
        }, "B");
        a.start();
        Thread.sleep(1000);
        b.start();
    }

    /**
     * 使用volatile修饰ok
     * B线程对ok操作会将ok的值刷回主内存
     * A线程每次读取ok都会从主内存中读取
     */
    static void case2() throws InterruptedException {
        var a = new Thread(() -> {
            while (ok) {
                //...
            }
            System.out.println("A线程从主内存中读取到ok=" + ok);
        }, "A");
        var b = new Thread(() -> {
            if (ok) {
                ok = false;
            }
            System.out.println("B线程将ok修改为: " + ok);
        }, "B");
        a.start();
        Thread.sleep(1000);
        b.start();
    }


    public static void main(String[] args) throws InterruptedException {
//        case1();
        case2();
    }
}
