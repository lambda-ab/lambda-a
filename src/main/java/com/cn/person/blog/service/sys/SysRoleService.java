package com.cn.person.blog.service.sys;

import com.cn.person.blog.entity.sys.SysRole;
import com.cn.person.blog.repository.sys.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moment
 * @date 2019/10/24 15:02
 * @describe
 */
@Service
public class SysRoleService {
    @Autowired
    SysRoleRepository sysRoleRepository;

    public void save(SysRole sysRole) {
        sysRoleRepository.save(sysRole);
    }


    public List<SysRole> querySysRolesByUserId(String userId) {
        return sysRoleRepository.querySysRolesByUserId(userId);
    }

}
