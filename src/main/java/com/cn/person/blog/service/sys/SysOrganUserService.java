package com.cn.person.blog.service.sys;

import com.cn.person.blog.entity.sys.SysOrganUser;
import com.cn.person.blog.repository.sys.SysOrganUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author moment
 * @date 2019/10/24 15:01
 * @describe
 */
@Service
public class SysOrganUserService {
    @Autowired
    SysOrganUserRepository sysOrganUserRepository;

    public void save(SysOrganUser sysOrganUser) {
        sysOrganUserRepository.save(sysOrganUser);
    }
}
