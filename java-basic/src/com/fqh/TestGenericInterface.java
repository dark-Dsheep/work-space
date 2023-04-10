package com.fqh;

public class TestGenericInterface {


    //====================测试泛型接口====================
    // interface Generator<T> {}
    // 实现泛型接口并指定类型: class GeneratorImpl implements Generator<String> {}
    //================================================

    interface Generator<T> { T m();}

    static class GeneratorImpl implements Generator<String> {
        @Override
        public String m() {
            return "abc";
        }
    }

    public static void main(String[] args) {
        Generator<String> generator = new GeneratorImpl();
        System.out.println(generator.m());
    }
}
