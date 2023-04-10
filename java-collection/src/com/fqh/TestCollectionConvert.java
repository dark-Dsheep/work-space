package com.fqh;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCollectionConvert {


    //=======================一些集合转换技巧==========================
    //==============================================================

    /**
     * 集合转Map
     */
    static void convertToMap() {
        var pairs = List.of(new Pair("k1", "v1"), new Pair("k2", "v2"));
        var map = pairs.stream().collect(Collectors.toMap(Pair::getK, Pair::getV));
        System.out.println(map);
    }

    /**
     * 集合转数组
     */
    static void convertToArray() {
        String[] ss = {"a", "b", "c"};
        List<String> list = Arrays.asList(ss);
        Collections.reverse(list);
        ss = list.toArray(new String[0]);
        System.out.println(Arrays.toString(ss));
    }


    static class Pair {
        private String k;
        private String v;

        public Pair(String k, String v) {
            this.k = k;
            this.v = v;
        }

        public String getK() {
            return k;
        }

        public void setK(String k) {
            this.k = k;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }

    public static void main(String[] args) {
//        convertToMap();
        convertToArray();
    }
}
