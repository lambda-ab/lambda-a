package com.cn.person.blog.repository.sys;

import com.cn.person.blog.entity.sys.SysPerm;
import com.cn.person.blog.entity.sys.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jea.b
 */
@Repository
public interface SysPermRepository extends JpaRepository<SysPerm, String> {

    @Query(value = "select from User u where u.name=:name and u.email=:email", nativeQuery = true)
    SysUser findByNameAndEmail(@Param("name") String name, @Param("email") String email);


    /**
     * 根据用户id查询权限
     *
     * @param userId
     * @return
     */
    @Query(value = "select DISTINCT tp.* from tb_sys_user tu,tb_sys_user_role tur,tb_sys_perm tp,tb_sys_role_perm trp " +
            "where tu.id=tur.user_id " +
            "and tur.role_id =trp.role_id " +
            "and trp.perm_id = tp.id " +
            "and tu.id=:userId;", nativeQuery = true)
    List<SysPerm> querySysPermsByUserId(@Param("userId") String userId);

}
