package com.fqh;

import java.lang.reflect.Field;

public class TestThreadLocal {

    //============================测试ThreadLocal=======================
    // ThreadLocal.class 线程本地变量
    //=================================================================

    static final ThreadLocal<Pair> holder = ThreadLocal.withInitial(() -> new Pair("k1", "v1"));

    static class Pair {
        String key;
        String value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "k='" + key + '\'' +
                    ", v='" + value + '\'' +
                    '}';
        }
    }

    static void show() {
        Pair pair = holder.get();
        System.out.println("MainThread: " + pair);
        var a = new Thread(() -> {
            holder.set(new Pair("x", "y"));
            System.out.println(Thread.currentThread().getName() + ": " + holder.get());
        }, "A");
        var b = new Thread(() -> {
            holder.set(new Pair("1", "2"));
            System.out.println(Thread.currentThread().getName() + ": " + holder.get());
        }, "B");
        a.start();
        b.start();
    }

    /**
     * ThreadLocal的key是弱引用,在GC后会被回收
     */
    static void afterGC() throws InterruptedException {
        var a = new Thread(() -> exec("abc", false));
        a.start();
        a.join();
        System.out.println("==========After GC===========");
        var b = new Thread(() -> exec("123", true));
        b.start();
        b.join();
    }

    static void exec(String s, boolean isGC) {
        try {
            new ThreadLocal<>().set(s);
            if (isGC) {
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object ThreadLocalMap = field.get(t);
            Class<?> tlmClass = ThreadLocalMap.getClass();
            Field tableField = tlmClass.getDeclaredField("table");
            tableField.setAccessible(true);
            Object[] arr = (Object[]) tableField.get(ThreadLocalMap);
            for (Object o : arr) {
                if (o != null) {
                    Class<?> entryClass = o.getClass();
                    Field valueField = entryClass.getDeclaredField("value");
                    Field referenceField = entryClass.getSuperclass().getSuperclass().getDeclaredField("referent");
                    valueField.setAccessible(true);
                    referenceField.setAccessible(true);
                    System.out.printf("弱引用key:%s,值:%s%n", referenceField.get(o), valueField.get(o));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        show();
        afterGC();
    }
}
