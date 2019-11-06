package com.cn.person.blog.controller;

import com.cn.person.blog.constant.CommonConstant;
import com.cn.person.blog.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author moment
 * @date 2019/10/24 9:42
 * @describe
 */
public class BaseController {


    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @ModelAttribute
    public void initMode(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public SysUser getSysUser() {
        return (SysUser) SecurityUtils.getSubject().getSession().getAttribute(CommonConstant.USER_KEY);
    }

    public Object getSessionAttribute(String key) {
        return SecurityUtils.getSubject().getSession().getAttribute(key);
    }

    public void setSessionAttribute(String key, Object value) {
        SecurityUtils.getSubject().getSession().setAttribute(key, value);
    }

    public void removeSessionAttribute(String key) {
        SecurityUtils.getSubject().getSession().removeAttribute(key);
    }


}
