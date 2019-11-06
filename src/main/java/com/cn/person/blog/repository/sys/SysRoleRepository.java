package com.cn.person.blog.repository.sys;

import com.cn.person.blog.entity.sys.SysRole;
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
public interface SysRoleRepository extends JpaRepository<SysRole, String> {

    @Query(value = "select from User u where u.name=:name and u.email=:email", nativeQuery = true)
    SysUser findByNameAndEmail(@Param("name") String name, @Param("email") String email);

    /**
     * 查询角色
     *
     * @param userId
     * @return
     */
    @Query(value = "select tr.* from tb_sys_user tu,tb_sys_user_role tur,tb_sys_role tr " +
            "where tu.id=tur.user_id\n" +
            "and tur.role_id =tr.id\n" +
            "and tu.id=:userId", nativeQuery = true)
    List<SysRole> querySysRolesByUserId(@Param("userId") String userId);

}
