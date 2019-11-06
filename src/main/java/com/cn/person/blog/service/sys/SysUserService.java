package com.cn.person.blog.service.sys;

import com.cn.person.blog.entity.sys.SysUser;
import com.cn.person.blog.repository.sys.SysUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author moment
 * @date 2019/10/24 15:02
 * @describe
 */
@Service
public class SysUserService {
    @Autowired
    SysUserRepository sysUserRepository;

    public void save(SysUser sysUser) {
        sysUserRepository.save(sysUser);
    }


    public SysUser findByName(String name) {
        return sysUserRepository.findByName(name);
    }

    public SysUser findByPhone(String phone) {
        return sysUserRepository.findByPhone(phone);
    }

    public void deleteById(String id) {
        sysUserRepository.deleteById(id);
    }


    public void update(SysUser sysUser) {
        SysUser sUser = sysUserRepository.findByUserId(sysUser.getId());
        if (sUser != null) {
            sUser.setRemark(sUser.getRemark());
            sysUserRepository.save(sUser);
        }
    }

    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }


    /**
     * 简答查询
     */
    public Page<SysUser> findPageByUserName(String name, Integer pageNum, Integer pageSize) {
        SysUser sysUser = new SysUser();
        sysUser.setName(name);
        Example<SysUser> example = Example.of(sysUser);

        //按照id降序排列
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = Sort.by(order);
        //查询
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize, sort);
        Page<SysUser> pageSysUser = sysUserRepository.findAll(example, pageRequest);
        return pageSysUser;
    }

    /**
     * 分页复杂查询
     *
     * @param name
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<SysUser> findPageByUserNameMo(String name, Integer pageNum, Integer pageSize) {

        //按照id降序排列
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = Sort.by(order);

        //页码：前端从1开始，jpa从0开始，做个转换
        Pageable pageRequest = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<SysUser> spec = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>(); //所有的断言
                if (StringUtils.isNotBlank(name)) { //添加断言
                    Predicate likeNickName = cb.like(root.get("nickName").as(String.class), name + "%");
                    predicates.add(likeNickName);
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
        Page<SysUser> pageSysUser = sysUserRepository.findAll(spec, pageRequest);

        return pageSysUser;
    }


}
