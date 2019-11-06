package com.cn.person.blog.service;

import com.cn.person.blog.entity.Answer;
import com.cn.person.blog.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author moment
 * @date 2019/10/24 15:03
 * @describe
 */
@Service
public class AnswerService {
    @Autowired
    AnswerRepository answerRepository;

    public void save(Answer answer) {
        answerRepository.save(answer);
    }
}
