package com.cn.person.blog.entity;

import lombok.Data;

/**
 * @author moment
 * @date 2019/10/24 15:44
 * @describe
 */
@Data
public class LoginParam {
    public static String LOGIN_TYPE_ADMIN = "private";
    public static String LOGIN_TYPE_PUBLIC = "public";

    private String account;

    private String password;

    private String picCode;

    private String loginType;
}
