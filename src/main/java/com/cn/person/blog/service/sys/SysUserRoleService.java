package com.cn.person.blog.service.sys;

import com.cn.person.blog.entity.sys.SysUserRole;
import com.cn.person.blog.repository.sys.SysUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author moment
 * @date 2019/10/24 15:03
 * @describe
 */
@Service
public class SysUserRoleService {
    @Autowired
    SysUserRoleRepository sysUserRoleRepository;

    public void save(SysUserRole sysUserRole) {
        sysUserRoleRepository.save(sysUserRole);
    }
}
