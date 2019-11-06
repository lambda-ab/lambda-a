package com.cn.person.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019/9/26 16:56
 * @describe
 */
@Setter
@Getter
@Entity
@Table(name = "tb_blog_image")
public class Image {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;
    private String title;
    private String imgUrl;
    private String remark;
    private Date createTime;
    private Date lastUpdateTime;
}
