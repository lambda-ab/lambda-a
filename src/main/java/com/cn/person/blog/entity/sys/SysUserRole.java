package com.cn.person.blog.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author moment
 * @date 2019/9/26 15:15
 */
@Setter
@Getter
@Entity
@Table(name = "tb_sys_user_role")
public class SysUserRole {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;
    private String userId;
    private String roleId;
}
