package com.cn.person.blog.service.sys;

import com.cn.person.blog.entity.sys.SysOperateLog;
import com.cn.person.blog.entity.sys.SysUser;
import com.cn.person.blog.repository.sys.SysOperateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moment
 * @date 2019/10/24 14:52
 * @describe
 */
@Service
public class SysOperateLogService {
    @Autowired
    SysOperateRepository sysOperateRepository;

    public void save(SysOperateLog sysOperateLog) {
        sysOperateRepository.save(sysOperateLog);
    }


    public void save(String className, String classMethod, SysUser sysUser) {
        SysOperateLog sysOperateLog = new SysOperateLog();
        sysOperateLog.setClassName(className);
        sysOperateLog.setClassMethod(classMethod);
        sysOperateLog.setUserId(sysUser.getId());
        sysOperateRepository.save(sysOperateLog);
    }

    public void deleteById(String id) {
        sysOperateRepository.deleteById(id);
    }


    public void update(SysOperateLog sysOperateLog) {
        SysOperateLog operaLog = sysOperateRepository.findByOperaId(sysOperateLog.getId());
        if (operaLog != null) {
            operaLog.setRemark(sysOperateLog.getRemark());
            sysOperateRepository.save(operaLog);
        }
    }

    public List<SysOperateLog> findAll() {
        return sysOperateRepository.findAll();
    }


}
