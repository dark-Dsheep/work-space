package com.fqh;

import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestTreeMap {

    //====================测试平衡树=========================
    // TreeSet<?> TreeMap<?, ?>
    // floor()找小于等于x的最大值 ceiling()找大于等于x的最小值
    // lower()找严格小于x的最大值 higher()找严格大于x的最小值
    //=====================================================

    static void m1() {
        var tset = new TreeSet<Integer>(List.of(2, 1, 3, 4, 9, 7, 11));
        int x = 3;
        // 返回小于等于x的最大值
        int l = tset.floor(x);
        // 返回大于等于x的最小值
        int r = tset.ceiling(x);
        // 返回严格小于x的最大值
        int a = tset.lower(x);
        // 返回严格大于x的最小值
        int b = tset.higher(x);

        System.out.println("小于等于" + x + "的最大值: " + l);
        System.out.println("大于等于" + x + "的最小值: " + r);
        System.out.println("严格小于" + x + "的最大值: " + a);
        System.out.println("严格大于" + x + "的最小值: " + b);
    }

    static void m2() {
        int[] arr = {1, 4, 5, 3, 9, 7};
        var tmap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            tmap.put(arr[i], i);
        }
        var entry = tmap.floorEntry(5);
        System.out.println(entry.getValue());
    }

    public static void main(String[] args) {
//        m1();
        m2();
    }
}
