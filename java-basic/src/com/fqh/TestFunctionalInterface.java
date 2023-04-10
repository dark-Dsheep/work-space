package com.fqh;

import java.util.List;

public class TestFunctionalInterface {


    //========================测试函数式接口@FunctionalInterface注解===================
    //==============================================================================

    @FunctionalInterface
    interface PrintInterface { void print();}
    static void testPrintInterface(PrintInterface pi) { pi.print(); }

    public static void main(String[] args) {
        testPrintInterface(() -> System.out.println("abc"));
        var list = List.of(1, 2, 3, 4, 5, 6);
        list.forEach(e -> System.out.println(e));
    }
}
