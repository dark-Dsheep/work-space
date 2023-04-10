package com.fqh;

import java.util.List;

public class TestGenericClass {


    //====================测试泛型类====================
    // class MyGeneric<T> {}
    // 实例化泛型类: var x = new MyGeneric<String>("ab");
    //================================================

    static class MyGeneric<T> {

        private T Key;

        public MyGeneric(T key) {
            Key = key;
        }

        public T getKey() {
            return Key;
        }
    }

    public static void main(String[] args) {
        var x = new MyGeneric<String>("ab");
        var y = new MyGeneric<Integer>(65535);
        var z = new MyGeneric<List<Integer>>(List.of(1,2,3));
        System.out.println(x.getKey());
        System.out.println(y.getKey());
        System.out.println(z.getKey());
    }
}
