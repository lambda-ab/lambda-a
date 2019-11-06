package com.cn.person.blog.service.sys;

import com.cn.person.blog.entity.sys.SysRequestLog;
import com.cn.person.blog.repository.sys.SysRequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author moment
 * @date 2019/10/24 14:40
 * @describe
 */
@Service
public class SysRequestLogService {
    @Autowired
    SysRequestLogRepository sysRequestLogRepository;

    public void save(SysRequestLog sysRequestLog) {
        sysRequestLogRepository.save(sysRequestLog);
    }
}
