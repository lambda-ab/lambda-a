package com.cn.person.blog.entity;

import lombok.Data;

/**
 * @author moment
 * @date 2019/10/24 9:56
 * @describe
 */
@Data
public class ResultVo {
    public static final int SUCCESS_CODE = 200;
    public static final int ERROR_CODE = 404;
    public static final int LOGIN_ERROR_CODE = 401;

    public static final String SUCCESS_MSG = "success";
    public static final String ERROR_MSG = "error";

    private int code = SUCCESS_CODE;
    private String msg = SUCCESS_MSG;
    private Object data;

}
