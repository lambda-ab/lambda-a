package com.cn.person.blog.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019.09.26 15:05:22
 */
@Setter
@Getter
@Entity
@Table(name = "tb_sys_user")
public class SysUser {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id")
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
    private Date createTime;
    private Date lastTime;
    private String remark;
}
