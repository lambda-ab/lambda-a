package com.cn.person.blog.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author moment
 * @date 2019/10/14 17:58
 * @describe
 */
@Setter
@Getter
@Entity
@Table(name = "tb_sys_organ_user")
public class SysOrganUser {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;
    private String orgId;
    private String userId;

}
