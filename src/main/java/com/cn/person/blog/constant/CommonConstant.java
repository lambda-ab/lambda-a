package com.cn.person.blog.constant;

/**
 * @author moment
 * @date 2019/10/24 9:44
 * @describe
 */
public class CommonConstant {
    public static final String USER_KEY = "userKey";


    /**
     * 验证码
     */
    public static final String CHECK_CODE = "checkCode";
    public static final String CHECK_CODE_NULL = "验证码为空";
    public static final String CHECK_CODE_ERROR = "验证码错误";
    public static final String CHECK_CODE_SUCCESS = "验证码错校验成功";


    /**
     * 请求失败
     */
    public static final int REQ_ERROR_CODE = 404;
    /**
     * 请求成功
     */
    public static final int REQ_SUCCESS_CODE = 200;
    /**
     * 登录失败
     */
    public static final int LOGIN_ERROR_CODE = 401;
    public static final String REQ_CN_ERROR = "错误";
    public static final String REQ_CN_SUCCESS = "成功";
    public static final String SYSTEM_ERROR = "系统繁忙";
    public static final String ACCOUNT_OR_PASSWORD_ERROR = "账号/登录密码错误!";
    public static final String ACCOUNT_NOT_EXIST_OR_STOP = "帐号不存在/已停用";

    public static final String STATUS_E = "E";

    public static final String PERM_TYPE_BUTTON = "1";
    public static final String PERM_TYPE_MENU = "2";
    public static final String PERM_TYPE_LIST = "3";

}
