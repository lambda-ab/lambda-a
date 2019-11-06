package com.cn.person.blog.service.sys;

import com.cn.person.blog.entity.sys.SysRolePerm;
import com.cn.person.blog.repository.sys.SysRolePermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author moment
 * @date 2019/10/24 15:02
 * @describe
 */
@Service
public class SysRolePermService {
    @Autowired
    SysRolePermRepository sysRolePermRepository;

    public void save(SysRolePerm sysRolePerm) {
        sysRolePermRepository.save(sysRolePerm);
    }
}
