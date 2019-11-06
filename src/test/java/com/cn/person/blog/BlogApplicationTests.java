package com.cn.person.blog;

import com.alibaba.fastjson.JSON;
import com.cn.person.blog.entity.sys.SysPerm;
import com.cn.person.blog.entity.sys.SysRole;
import com.cn.person.blog.entity.sys.SysUser;
import com.cn.person.blog.service.sys.SysPermService;
import com.cn.person.blog.service.sys.SysRoleService;
import com.cn.person.blog.service.sys.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired
    SysPermService sysPermService;

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService sysRoleService;

    @Test
    public void addUser() {
//        SysUser sysUser = new SysUser();
//        sysUser.setAddress("测试数据很多");
//        sysUser.setAge(16);
//        sysUser.setName("xiaowang");
//        sysUser.setNickName("xiaowang");
//        sysUser.setCreateTime(new Date());
//        sysUser.setLastTime(new Date());
//        sysUser.setStatus("E");
//        sysUserService.save(sysUser);

        SysUser sysUser = new SysUser();
        sysUser.setAddress("测试数据很多");
        sysUser.setAge(16);
        sysUser.setName("xiaosun");
        sysUser.setNickName("xiaosun");
        sysUser.setCreateTime(new Date());
        sysUser.setLastTime(new Date());
        sysUser.setStatus("E");
        sysUserService.save(sysUser);
    }

    @Test
    public void addRole() {
        SysRole sysRole = new SysRole();
        sysRole.setName("admin");
        sysRole.setIntroduce("admin");
        sysRole.setRemark("admin");
        sysRole.setCreateTime(new Date());
        sysRole.setStatus("E");
        sysRoleService.save(sysRole);

//        SysRole sysRole = new SysRole();
//        sysRole.setName("normal");
//        sysRole.setIntroduce("normal");
//        sysRole.setRemark("normal");
//        sysRole.setCreateTime(new Date());
//        sysRole.setStatus("E");
//        sysRoleService.save(sysRole);
    }

    @Test
    public void addPerm() {
        /*SysPerm sysPerm = new SysPerm();
        sysPerm.setPermName("系统管理");
        sysPerm.setPermCode("sysManager");
        sysPerm.setPermUrl("");
        sysPerm.setPermType(1);
        sysPerm.setRemark("系统管理");
        sysPerm.setCreateTime(new Date());
        sysPerm.setStatus("E");
        sysPermService.save(sysPerm);*/

        SysPerm sysPerm = new SysPerm();
        sysPerm.setPermName("组织机构管理");
        sysPerm.setPermCode("organ:manager");
        sysPerm.setPermUrl("");
        sysPerm.setPermType(1);
        sysPerm.setUpPermId("4028b8816e009196016e0091aaf80000");
        sysPerm.setUpPermName("系统管理");
        sysPerm.setRemark("组织机构管理");
        sysPerm.setCreateTime(new Date());
        sysPerm.setStatus("E");
        sysPermService.save(sysPerm);
    }

    @Test
    public void querySysRolesByUserId() {
        String userId = "4028b8816e008af9016e008b0f8a0000";
        System.out.println(JSON.toJSONString(sysRoleService.querySysRolesByUserId(userId)));
    }

}
