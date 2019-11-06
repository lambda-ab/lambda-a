package com.cn.person.blog.repository.sys;

import com.cn.person.blog.entity.sys.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jea.b
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, String>, JpaSpecificationExecutor<SysUser> {

    /**
     * 根据名称查询
     *
     * @param name
     * @return
     */
    SysUser findByName(String name);

    /**
     * 根据号码查询
     *
     * @param phone
     * @return
     */
    SysUser findByPhone(String phone);


    @Query(value = "select t.* from tb_sys_user t where t.id=:id", nativeQuery = true)
    SysUser findByUserId(@Param("id") String id);


}
