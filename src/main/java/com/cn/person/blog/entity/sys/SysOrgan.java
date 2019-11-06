package com.cn.person.blog.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019/10/14 17:56
 * @describe 组织机构
 */
@Setter
@Getter
@Entity
@Table(name = "tb_sys_organ")
public class SysOrgan {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;
    private String upOrgId;
    private String orgName;
    private String orgCode;
    private String introduce;
    private String status;
    private Date createTime;
    private String remark;
}
