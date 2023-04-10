package com.fqh;

public class TestStringPerformance {


    //================测试String,StringBuilder,StringBuffer字符串拼接性能==============
    // spliceByString cost ===> 3395ms (常量池产生大量字符串)
    // spliceByString cost ===> 11ms
    // spliceByString cost ===> 8ms
    //==============================================================================


    static int N = 100001;

    static void spliceByString() {
        var s = "";
        long st = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            s += i;
        }
        long ed = System.currentTimeMillis();
        System.out.println("spliceByString cost ===> " + (ed - st) + "ms");
    }

    static void spliceByStringBuffer() {
        var sbf = new StringBuilder();
        long st = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            sbf.append(i);
        }
        long ed = System.currentTimeMillis();
        System.out.println("spliceByStringBuffer cost ===> " + (ed - st) + "ms");
    }

    static void spliceByStringBuilder() {
        var sbd = new StringBuilder();
        long st = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            sbd.append(i);
        }
        long ed = System.currentTimeMillis();
        System.out.println("spliceByStringBuilder cost ===> " + (ed - st) + "ms");
    }


    public static void main(String[] args) {
//        spliceByString();
//        spliceByStringBuffer();
        spliceByStringBuilder();
    }
}
