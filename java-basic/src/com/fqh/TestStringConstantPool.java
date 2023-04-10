package com.fqh;

public class TestStringConstantPool {

    //======================测试字符串常量池===============================
    // String aa = "ab"; 在堆中创建字符串对象"ab",将字符串对象"ab"的引用保存在字符串常量池
    // String bb = "ab"; 直接返回字符串常量池中"ab"的引用
    // String.intern()方法可以将字符串的引用保存到常量池并返回
    // 两种情况: 1.常量池已经存在就直接返回 2.常量池不存在则先保存后再返回
    //==================================================================

    static void saveToConstantPoolByIntern() {
        var p = "ab";   // 提前加入常量池
        var s = new String("ab");
        System.out.println(s.intern() == p);
        var constantS1 =  s.intern();
        var constantS2 =  s.intern();
        System.out.println(constantS1 == constantS2);
    }

    public static void main(String[] args) {
//        var aa = "ab";
//        var bb = "ab";
//        System.out.println(aa == bb);
        saveToConstantPoolByIntern();
    }
}
