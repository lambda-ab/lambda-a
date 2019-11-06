package com.cn.person.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author moment
 */
@Configuration   //标注一个类是配置类，spring boot在扫到这个注解时自动加载这个类相关的功能，比如前面的文章中介绍的配置AOP和拦截器时加在类上的Configuration
@EnableJpaRepositories(basePackages = {"com.cn.person.blog.repository"})
@ComponentScan(value = {"com.cn.person.blog.*"})//扫描组件 @ComponentScan(value = "com.spriboot.controller") 配置扫描组件的路径
@SpringBootApplication
//@EntityScan("entity对应的包路径")
@EntityScan("com.cn.person.blog.entity")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
        System.out.println("===============BlogApplication启动成功============");
    }

}
