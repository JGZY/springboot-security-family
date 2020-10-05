package com.wj.springsecurity.mapper;

import com.wj.springsecurity.domain.SysRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends Mapper<SysRole> {

    @Select("select r.id,r.role_name as roleName,r.role_desc as roleDesc " +
            "from sys_role r , sys_user_role ur " +
            "where uid = #{uid} and r.id = ur.rid")
    public List<SysRole> findByUid(Integer uid);
}
