package com.cn.person.blog.repository;

import com.cn.person.blog.entity.Question;
import com.cn.person.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author moment
 * @date 2019/10/14 17:49
 * @describe
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
}
