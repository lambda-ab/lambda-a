package com.cn.person.blog.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019/9/26 15:49
 */
@Setter
@Getter
@Entity
@Table(name = "tb_sys_request_log")
public class SysRequestLog {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;

    private Date createTime;

    private String httpMethod;

    private String isAjax;

    private String remoteAddr;

    private String remoteHost;

    private String requestMethod;

    private String requestParameter;

    private String requestUri;

    private String result;

    private String userId;

    private String logType;

    private Long useTime;
}
