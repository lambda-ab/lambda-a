package com.cn.person.blog.service;

import com.cn.person.blog.entity.Strategy;
import com.cn.person.blog.repository.StrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author moment
 * @date 2019/10/24 15:05
 * @describe
 */
@Service
public class StrategyService {
    @Autowired
    StrategyRepository strategyRepository;

    public void save(Strategy strategy) {
        strategyRepository.save(strategy);
    }
}
