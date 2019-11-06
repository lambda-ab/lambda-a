package com.cn.person.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019/9/26 16:06
 */
@Setter
@Getter
@Entity
@Table(name = "tb_blog_user")
public class User {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;
    private String name;
    private String password;
    private String nickName;
    private String email;
    private String phone;
    private String address;
    @Column(name = "introduce", length = 1000)
    private String introduce;
    private int age;
    @Column(name = "education", length = 200)
    private String education;
    private int sex;
    /**
     * 地区
     */
    private String area;
    /**
     * 职业
     */
    private String profession;
    private String status;
    private String remark;
    private Date createTime;
    private Date lastUpdateTime;
}
