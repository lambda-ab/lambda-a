package com.cn.person.blog.entity.sys;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019/9/26 15:50
 */
@Getter
@Setter
@Entity
@Table(name = "tb_sys_operate_log")
public class SysOperateLog {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;
    /**
     * class
     */
    private String className;
    /**
     * 操作方法
     */
    private String classMethod;
    /**
     * 操作人 操作人id
     */
    private String userId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 备注
     */
    private String remark;
}
