package com.cn.person.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019/9/26 16:31
 */
@Setter
@Getter
@Entity
@Table(name = "tb_blog_question")
public class Question {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;

    private String userId;

    private String firstLevelCategory;
    private String secondLevelCategory;
    private String threeLevelCategory;

    private String content;

    private String createTime;

    private Date lastUpdateTime;
}
