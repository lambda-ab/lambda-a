package com.cn.person.blog.utils;


import java.util.Base64;

/**
 * @author Administrator
 * @date 2019/4/12
 */
public class Base64Util {

    public static String encode(String str) {
        try {
            return Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
    }

    public static String decode(String str) {
        try {
            return new String(Base64.getDecoder().decode(str), "UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Base64Util.encode("wyx.123456"));
    }

}
