package com.cn.person.blog.repository.sys;

import com.cn.person.blog.entity.sys.SysOrgan;
import com.cn.person.blog.entity.sys.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author jea.b
 */
@Repository
public interface SysOrganRepository extends JpaRepository<SysOrgan, String> {

    @Query(value = "select from User u where u.name=:name and u.email=:email", nativeQuery = true)
    SysUser findByNameAndEmail(@Param("name") String name, @Param("email") String email);

}
