package com.cn.person.blog.repository;

import com.cn.person.blog.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author moment
 * @date 2019/10/14 17:49
 * @describe
 */
@Repository
public interface ImageConfigRepository extends JpaRepository<Image, String> {
}
