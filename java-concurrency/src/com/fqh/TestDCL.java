package com.fqh;

public class TestDCL {


    //==============================测试DCL(单例模式双重检查锁)=========================
    // volatile防止指令重排序
    //==============================================================================

    static class Singleton {

        private volatile static Singleton instance;

        private Singleton() {}

        public static Singleton getInstance() {
            // 先判断对象是否已经实例过
            if (instance == null) {
                // 类对象加锁
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                        // new 对象分三条指令执行
                        // 1.instance分配内存空间
                        // 2.初始化instance
                        // 3.将instance执行分配的内存地址
                        // JVM可能进行指令重排序优化,执行顺序变为1->3->2,这样我们就拿到了一个还没有初始化的对象实例,这是不正确的
                    }
                }
            }
            return instance;
        }
    }


    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a.hashCode() == b.hashCode());
    }
}
