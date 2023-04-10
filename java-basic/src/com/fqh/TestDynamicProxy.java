package com.fqh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {


    //=================测试JDK动态代理========================
    // 实现InvocationHandler接口
    // class MyHandler impl InvocationHandler {}
    // Proxy.newProxyInstance创建代理对象
    //======================================================

    interface Calculator {
        void add(int a, int b);

        void subtract(int a, int b);
    }

    static class CalculatorImpl implements Calculator {
        @Override
        public void add(int a, int b) {
            System.out.println(a + b);
        }

        @Override
        public void subtract(int a, int b) {
            System.out.println(a - b);
        }
    }


    static class MyInvocationHandler implements InvocationHandler {
        /**
         * 目标对象
         */
        private final Object t;

        public MyInvocationHandler(Object t) {
            this.t = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before doInvoke current time " + System.currentTimeMillis());
            Object res = method.invoke(t, args);
            System.out.println("after doInvoke current time " + System.currentTimeMillis());
            return res;
        }
    }


    public static void main(String[] args) {
        Calculator calc = new CalculatorImpl();
        Calculator proxy = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(), new Class[]{Calculator.class}, new MyInvocationHandler(calc));
        proxy.add(2, 3);
        proxy.subtract(5, 2);
    }
}
