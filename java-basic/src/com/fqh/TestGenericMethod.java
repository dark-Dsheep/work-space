package com.fqh;

import java.util.List;

public class TestGenericMethod {


    //========================测试泛型方法=========================
    // <E> void methodName(E[] arr) 传入泛型数组
    // <E> void printObj(E e) 传入泛型对象
    //===========================================================

    static <E> void printArray(E[] arr) {
        for (E e : arr) {
            System.out.printf("%s", e);
        }
        System.out.println();
    }

    static <E> void printObj(E e) {
        System.out.println(e);
    }

    public static void main(String[] args) {
        Integer[] x = {1, 2, 3};
        String[] y = {"a", "b", "c"};
        printArray(x);
        printArray(y);
        var z = List.of(1L, 2L, 3L);
        printObj(z);
    }
}
