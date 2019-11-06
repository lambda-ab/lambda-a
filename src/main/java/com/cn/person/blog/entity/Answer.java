package com.cn.person.blog.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moment
 * @date 2019/9/26 16:32
 */
@Setter
@Getter
@Entity
@Table(name = "tb_blog_answer")
public class Answer {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @Column(name = "id", length = 32)
    private String id;

    private String userId;
    /**
     * 回答类型 "1"问题 "2" 攻略
     */
    private int answerType;

    private String questionIdOrStrategyId;
    /**
     * 问题ID或回答ID
     */
    private String upId;

    private String content;

    private String createTime;

    private Date lastUpdateTime;
}
