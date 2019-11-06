package com.cn.person.blog.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tangc
 * @date
 **/
@Slf4j
public class DateUtil {
    public static final SimpleDateFormat FORMAT_YYYYMMDDHHMMSS_NOMARL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat CRON_TIME = new SimpleDateFormat("ss mm HH * * ? *");
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Map<String, Object> getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Map<String, Object> dateMap = new HashMap<String, Object>();
        Calendar cal = Calendar.getInstance();
        dateMap.put("endTime", sdf.format(cal.getTime()));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        dateMap.put("startTime", sdf.format(cal.getTime()));
        return dateMap;
    }

    public static String getDateBeforeTwoYMD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return sdf.format(calendar.getTime());
    }

    public static String getDateBeforeSevenYMD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -6);
        return sdf.format(calendar.getTime());
    }

    public static String getNowDateYMD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * @author tangc
     * 获取马上执行的 crontime 当前时间+2秒~
     **/
    public static String getImmediatelyCronTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 2);
        String cronTime = CRON_TIME.format(calendar.getTime());
        return cronTime;
    }

    public static Map<String, Object> formatBeforeMinDate(Integer from, Integer to) {
        Map<String, Object> map = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -1 * to);// 15分钟之前的时间
        map.put("endTime", FORMAT_YYYYMMDDHHMMSS_NOMARL.format(cal.getTime()));
        cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -1 * from);// 30分钟之前的时间
        map.put("startTime", FORMAT_YYYYMMDDHHMMSS_NOMARL.format(cal.getTime()));
        return map;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(formatBeforeMinDate(30, 15)));
        System.out.println(getDateBeforeTwoYMD(new Date()));
        System.out.println(getDateBeforeSevenYMD(new Date()));
    }

    /**
     * 14位的时间字符串
     *
     * @param date
     * @return String
     */
    public static synchronized String get14DateFormat(Date date) {
        String pattern = "yyyyMMddHHmmss";
        return getDateFormat(date, pattern);
    }

    public static synchronized String getDateFormat(Date date, String pattern) {
        synchronized (sdf) {
            String str = null;
            sdf.applyPattern(pattern);
            str = sdf.format(date);
            return str;
        }
    }
}
