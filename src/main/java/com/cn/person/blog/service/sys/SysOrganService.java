package com.cn.person.blog.service.sys;

import com.cn.person.blog.entity.sys.SysOrgan;
import com.cn.person.blog.repository.sys.SysOrganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author moment
 * @date 2019/10/24 15:01
 * @describe
 */
@Service
public class SysOrganService {
    @Autowired
    SysOrganRepository sysOrganRepository;

    public void save(SysOrgan sysOrgan) {
        sysOrganRepository.save(sysOrgan);
    }
}
