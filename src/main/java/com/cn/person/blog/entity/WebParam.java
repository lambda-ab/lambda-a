package com.cn.person.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019/9/26 16:44
 * @describe 配置页面展示参数
 */
@Setter
@Getter
@Entity
@Table(name = "tb_blog_web_param")
public class WebParam {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;
    private String paramCode;
    private String paramName;
    private String paramValue;
    private String remark;
    private Date createTime;
    private Date lastUpdateTime;
}
