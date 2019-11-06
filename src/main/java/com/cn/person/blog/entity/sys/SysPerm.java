package com.cn.person.blog.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019/9/26 15:14
 */
@Setter
@Getter
@Entity
@Table(name = "tb_sys_perm")
public class SysPerm {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;

    private String permName;
    /**
     * 权限类型(菜单 按钮（目录）)
     */
    private int permType;

    private String permCode;
    /**
     * 地址
     */
    private String permUrl;

    private String remark;

    private String status;

    private Date createTime;

    private String upPermId;

    private String upPermName;

}
