package com.fqh;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class TestDateTimeAPI {

    //========================测试JDK1.8的 LocalDateTime类===========================
    // JDK1.8 LocalDateTime.class LocalDate.class LocalTime.class
    //================================================================


    static void oldFormat() {
        var now = new Date();
        // format yyyy-MM-dd
        var sdf = new SimpleDateFormat("yyyy-MM-dd");
        var date = sdf.format(now);
        System.out.println(String.format("date format : %s", date));

        // format HH:mm:ss
        var sdft = new SimpleDateFormat("HH:mm:ss");
        var time = sdft.format(now);
        System.out.println(String.format("time format : %s", time));

        // format yyyy-MM-dd HH:mm:ss
        var sdfdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        var datetime = sdfdt.format(now);
        System.out.println(String.format("dateTime format : %s", datetime));
    }

    /**
     * 日期格式化
     */
    static void newFormat() {
        // format yyyy-MM-dd
        var date = LocalDate.now();
        System.out.println(String.format("date format : %s", date));
        // format HH:mm:ss
        var time = LocalTime.now().withNano(0);
        System.out.println(String.format("time format : %s", time));
        // format yyyy-MM-dd HH:mm:ss
        var dateTime =  LocalDateTime.now();
        var dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        var dateTimeStr = dateTime.format(dtf);
        System.out.println(String.format("dateTime format : %s", dateTimeStr));
    }

    /**
     * 字符串转日期格式
     */
    static void strCastDate() {
        var date = LocalDate.of(2023, 4, 10);
        LocalDate.parse("2023-04-10");

        var dateTime = LocalDateTime.of(2023, 4, 10, 14, 35, 10);
        LocalDateTime.parse("2023-04-10 14:36:22");

        var time = LocalTime.of(12, 12, 22);
        LocalTime.parse("12:12:22");
    }

    /**
     * 日期计算
     */
    static void calcDate() {
        // 计算一周以后的日期
        var now = LocalDate.now();
        // 两种方式
        var a = now.plus(1, ChronoUnit.WEEKS);
        var b = now.plusWeeks(1);

        // 计算两个日期间隔多少天, 计算间隔多少年, 多少月
        var d1 = LocalDate.parse("2023-02-26");
        var d2 = LocalDate.parse("2023-12-26");
        var p = Period.between(d1, d2);
        System.out.println("d1 到 d2 相隔: "
                + p.getYears() + "年"
                + p.getMonths() + "月"
                + p.getDays() + "天");
        // 获取相隔的总天数采用以下方法
        long sum = d2.toEpochDay() - d1.toEpochDay();
        System.out.println(d1 + "和" + d2 + "相差 " + sum + "天");
    }

    /**
     * 获取指定日期
     */
    static void getSpecifyDay() {
        var now = LocalDate.now();
        // 获取本月第一天
        var a = now.with(TemporalAdjusters.firstDayOfMonth());
        // 获取本月最后一天
        var b = now.with(TemporalAdjusters.lastDayOfMonth());
        // 本年最后一天
        var c = now.with(TemporalAdjusters.lastDayOfYear());
        // 取下一天
        var nextDay = now.plusDays(1);
        // 2023年最后一个周日
        var currentYearLastSunDay = LocalDate.parse("2023-12-31").with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));

    }

    public static void main(String[] args) {
//        oldFormat();
//        newFormat();
        calcDate();
    }
}
