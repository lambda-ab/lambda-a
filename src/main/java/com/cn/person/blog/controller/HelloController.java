package com.cn.person.blog.controller;

import com.cn.person.blog.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author moment
 * @date 2019/9/27 15:41
 * @describe
 */
@CrossOrigin
@Slf4j
@Controller
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("sayHello")
    @ResponseBody
    public String SayHello() {
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.debug("debug");
        return "hello";
    }

    @RequestMapping("login01")
    @ResponseBody
    public User login() {
        User user = new User();
        user.setName("2Dog");
        user.setNickName("2Dog");
        return user;
    }

    @RequestMapping("user/check")
    @ResponseBody
    public User loginCheck() {
        User user = new User();
        user.setName("2Dog");
        user.setNickName("2Dog");
        return user;
    }


}
