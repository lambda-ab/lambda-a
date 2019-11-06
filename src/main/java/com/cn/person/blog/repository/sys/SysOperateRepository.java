package com.cn.person.blog.repository.sys;

import com.cn.person.blog.entity.sys.SysOperateLog;
import com.cn.person.blog.entity.sys.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jea.b
 */
@Repository
public interface SysOperateRepository extends JpaRepository<SysOperateLog, String> {

    @Query(value = "select tu.* from tb_sys_operate_log tu where tu.id=:id", nativeQuery = true)
    SysOperateLog findByOperaId(@Param("id") String id);

}
