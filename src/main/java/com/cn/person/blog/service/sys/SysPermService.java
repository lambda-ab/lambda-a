package com.cn.person.blog.service.sys;

import com.cn.person.blog.entity.sys.SysPerm;
import com.cn.person.blog.repository.sys.SysPermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moment
 * @date 2019/10/24 15:02
 * @describe
 */
@Service
public class SysPermService {
    @Autowired
    SysPermRepository sysPermRepository;

    public void save(SysPerm sysPerm) {
        sysPermRepository.save(sysPerm);
    }

    public List<SysPerm> querySysPermsByUserId(String userId) {
        return sysPermRepository.querySysPermsByUserId(userId);
    }

}
