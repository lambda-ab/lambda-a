package com.cn.person.blog.utils;

import java.util.UUID;

public class UuidUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

